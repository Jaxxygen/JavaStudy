import HTMLParser.HTMLConnector;
import MetroInfoHolder.InfoHolder;
import MetroInfoHolder.JSONWriter;
import MetroInfoHolder.Station;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        //Парсинг веб-страницы
//        HTMLConnector htmlConnector = new HTMLConnector("https://skillbox-java.github.io");
//        System.out.println(htmlConnector);

        //Поиск файлов по директориям
//            FileFounder.FileFounder fileFounder = new FileFounder.FileFounder("data/", "csv");
//            FileFounder.FileFounder fileFounder1 = new FileFounder.FileFounder("data/", "json");
//            System.out.println(fileFounder);
//            System.out.println(fileFounder1);

        //Парсинг JSON файлов
//        try {
//            JSONParser jsonParser = new JSONParser("data/2/4/depths-1.json");
//            System.out.println(jsonParser);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //Парсинг CSV файла
//        try {
//            CSVParser csvParser = new CSVParser("data/0/5/dates-2.csv");
//            System.out.println(csvParser);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

            InfoHolder infoHolder = new InfoHolder("https://skillbox-java.github.io/");
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.writeJSONLineList(infoHolder.getLineList());
        jsonWriter.writeJSONStationList(infoHolder.getLineList());





    }
}
