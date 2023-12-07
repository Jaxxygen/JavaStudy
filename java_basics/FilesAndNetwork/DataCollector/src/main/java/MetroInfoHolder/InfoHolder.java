package MetroInfoHolder;

import CSVParser.CSVParser;
import FileFounder.FileFounder;
import HTMLParser.HTMLConnector;
import JSONParser.JSONParser;

import java.util.*;

public class InfoHolder {
    TreeMap<String, Station> stationsMap = new TreeMap<>();
    ArrayList<Line> lineList = new ArrayList<>();

    public InfoHolder(String path) {

        //Получение станций и линий из HTML кода
            HTMLConnector htmlConnector = new HTMLConnector(path);
            htmlConnector.getLinesNumbersNamesMap().forEach((lineNumber, lineName) -> { // lineNumber - это поле "Номер линии" у LineParser в HTMLParser
                ArrayList<Station> stationsList = new ArrayList<>();
                htmlConnector.getLineNumberStationNumberNameMap().forEach((lineNumber2, station) ->   // lineNumber2 - это поле "Номер линии" у StationsParser в HTMLParser
                        station.forEach((stationNumber, stationName) -> {
                            if (lineNumber2.equals(lineNumber)) {
                                for (int i = 0; i < stationName.length; i++) {
                                    stationsList.add(new Station(stationName[i], lineName, "", "", false));
                                }
                                addLine(lineName, lineNumber, stationsList);
                                stationsList.clear();
                            }
                        }));
                });
            //Получение наличия переходов станций
            htmlConnector.getStationsWithConnection().forEach((lineName, hasConnection) -> {
                setStationHasConnection(lineName, hasConnection);
            });

        //Поиск, извлечение и добавление информации о глубине из JSON файлов
        FileFounder jsonFileFounder = new FileFounder("data/", ".json");
        ArrayList<String> jsonPathList = new ArrayList<>(jsonFileFounder.getPathList());
        jsonPathList.forEach(element -> {
            Map <String, String> stationNameDepthMap;
            try {
                JSONParser jsonParser = new JSONParser(element);
               stationNameDepthMap = jsonParser.getStationsNameDepthMap();
               stationNameDepthMap.forEach((stationName, stationDepth) -> setStationDepth(stationName, stationDepth));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        //Поиск, получение и добавление информации о дате из CSV файлов
        FileFounder csvFileFounder = new FileFounder("data/", ".csv");
        ArrayList<String> csvPathList = new ArrayList<>(csvFileFounder.getPathList());
        csvPathList.forEach(element -> {
            Map<String, String> stationNameDateMap;
            try {
                CSVParser csvParser = new CSVParser(element);
                stationNameDateMap = csvParser.getStationsNameDateMap();
                stationNameDateMap.forEach((stationName, stationDate) -> setStationDate(stationName, stationDate));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public TreeMap<String, Station> getStationsMap() {
        return stationsMap;
    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }

    public void setStationDepth(String stationName, String depth) {
        lineList.forEach(line -> {
            ArrayList<Station> stationArrayList = new ArrayList<>(line.getStations());
            stationArrayList.forEach(station -> {
                if (station.getStationName().equals(stationName)) {
                    if (station.getDepth().equals("")) {
                        station.setDepth(depth);
                    }
                }
            });
        });
    }
    public void setStationDate(String stationName, String date) {
        lineList.forEach(line -> {
            ArrayList<Station> stationArrayList = new ArrayList<>(line.getStations());
            stationArrayList.forEach(station -> {
                if (station.getStationName().equals(stationName)) {
                    if (station.getDate().equals("")) {
                        station.setDate(date);
                    }
                }
            });
        });
    }
    public  void setStationHasConnection(String stationName, boolean hasConnection) {
        lineList.forEach(line -> {
            ArrayList<Station> stationArrayList = new ArrayList<>(line.getStations());
            stationArrayList.forEach(station -> {
                if (station.getStationName().equals(stationName)) {
                    if (station.isHasConnection() == false) {
                        station.setHasConnection(hasConnection);
                    }
                }
            });
        });
    }

}
