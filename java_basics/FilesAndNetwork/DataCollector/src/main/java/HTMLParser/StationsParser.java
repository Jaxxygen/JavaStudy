package HTMLParser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;

public class StationsParser {
    Document document;
    Elements linesStations;
    private Map<String, Boolean> stationsWithConnection = new TreeMap<>();
    private Map<String, Map<Integer[], String[]>> lineNumberStationNumberNameMap = new HashMap<>();
    public StationsParser (Document document) {
        this.document = document;
        linesStations = document.select("div[data-line]");
        getLineNumberStationNumberNameMap();
    }
    public Map<String, Map<Integer[], String[]>> getLineNumberStationNumberNameMap() {
        linesStations.forEach(elementOfLine ->
        {
            //Разбивка HTML кода по линиям
            String lineNumber = elementOfLine.attr("data-line");

            //Добавление номера станции в лист
            Elements oneStationNum = elementOfLine.select("p > span[class='num']");
            List<Integer> stationsNumbers = new ArrayList<>();
            oneStationNum.forEach(elementOfOneStation -> {
                String regex = "[^0-9]";
                stationsNumbers.add(Integer.parseInt(elementOfOneStation.text().replaceAll(regex,"")));
            });

            //Добавление названия станции в лист
            Elements oneStationName = elementOfLine.select("p > span[class='name']");
            List<String> stationsNames = new ArrayList<>();
            oneStationName.forEach(elementOfOneStation -> stationsNames.add(elementOfOneStation.text()));

            //Добавление станций с переходом в отдельный лист
            Elements oneStationHasConnection = elementOfLine.select("p[class='single-station']");
            oneStationHasConnection.forEach(stationHasConnection -> {
                if (stationHasConnection.select("span[title]").hasAttr("title")) {
                    stationsWithConnection.put(stationHasConnection.select("span[class='name']").text(), true);
                }
            });

            Map<Integer[], String[]> stationsNumberAndNamesMap = new HashMap<>();
            stationsNumberAndNamesMap.put(stationsNumbers.toArray(new Integer[0]), stationsNames.toArray(new String[0]));

            lineNumberStationNumberNameMap.put(lineNumber, stationsNumberAndNamesMap);
        });
        return lineNumberStationNumberNameMap;
    }

    public Map<String, Boolean> getStationsWithConnection() {
        return stationsWithConnection;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Map<Integer[], String[]>> entry : lineNumberStationNumberNameMap.entrySet()) {
            builder.append("Линия: ").append(entry.getKey()).append("\n");
            for (Map.Entry<Integer[], String[]> secEntry : entry.getValue().entrySet()) {
                for (int i = 0; i < secEntry.getKey().length; i++)
                {
                    builder.append(" Станция  №").append(secEntry.getKey()[i])
                            .append(" ").append(secEntry.getValue()[i]).append("\n");
                }
            }
        }
        return builder.toString();
    }
}
