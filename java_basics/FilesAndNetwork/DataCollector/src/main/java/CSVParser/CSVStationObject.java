package CSVParser;

public class CSVStationObject {

    String name;
    String date;

    public CSVStationObject(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Наименование: ").append(getName()).append(" Дата: ").append(getDate()).append("\n");
        return builder.toString();
    }
}
