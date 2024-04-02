package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 01;
        int month = 01;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();
        String info = "";

        for (int age = -1; dateOfBirth.isBefore(today) || dateOfBirth.isEqual(today); dateOfBirth = dateOfBirth.plusYears(1)) {
            age++;
            String text = age + " - " + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - EE",Locale.US)) + "\n";
            info = info + text;
        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return info;
    }
}
