import java.sql.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "956840725130MyDB!";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            connection.createStatement().executeUpdate("CREATE TABLE average_purchases (" +
                    "course_name VARCHAR(35)," +
                    "average_purchases_per_month FLOAT);");
            ResultSet coursesNames = connection.createStatement().executeQuery("SELECT DISTINCT course_name FROM PurchaseList ");

            while (coursesNames.next()) {
                ResultSet coursesSold = connection.createStatement().executeQuery("SELECT pl.course_name, pl.subscription_date " +
                        "FROM PurchaseList pl " +
                        "WHERE pl.course_name = \"" + coursesNames.getString("course_name") + "\" " +
                        "ORDER BY pl.subscription_date;");

                int countOfCoursesSold = 0;
                LinkedList<Integer> rangeOfMonths = new LinkedList<>();
                String nameOfCourse = null;

                while (coursesSold.next()) {
                    ResultSet getMonth = connection.createStatement().executeQuery("SELECT MONTH(\"" + coursesSold.getString("subscription_date") + "\") AS month");
                    getMonth.next();
                    rangeOfMonths.add(getMonth.getInt("month"));
                    countOfCoursesSold++;
                    nameOfCourse = coursesSold.getString("course_name");
                }

                float firstNumber = rangeOfMonths.getFirst();
                float lastNumber = rangeOfMonths.getLast();
                float averagePurchases = countOfCoursesSold / (lastNumber - firstNumber + 1);

                connection.createStatement().executeUpdate("INSERT INTO average_purchases (course_name, average_purchases_per_month)" +
                            "VALUES (\"" + nameOfCourse + "\"," + averagePurchases + ");");
            }

            ResultSet averagePurchases = connection.createStatement().executeQuery("SELECT * FROM average_purchases");
            while (averagePurchases.next()) {
                System.out.println(averagePurchases.getString(1) + "|" + averagePurchases.getString(2));
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
