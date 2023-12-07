package CSVParser;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CSVParser {
    CSVStationObject csvList;
    List<CSVStationObject> stations = new ArrayList<>();
    Map<String, String> stationNameDateMap = new TreeMap<>();
    int skipFirstLine = 0;

    public CSVParser(String path) throws Exception {
        List<String> csv = Files.readAllLines(Paths.get(path));
        csv.forEach(e -> {
            if (skipFirstLine != 0) {
                String[] parsedCsv = e.split(",");
                stations.add(new CSVStationObject(parsedCsv[0], parsedCsv[1]));
                stationNameDateMap.put(parsedCsv[0],parsedCsv[1]);
            }
            skipFirstLine++;
         });
    }
    public Map<String, String> getStationsNameDateMap() {
        return stationNameDateMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        stations.forEach(s -> builder.append("Станция: ").append(s.getName())
                .append("    Дата:").append(s.getDate()).append("\n"));
        return builder.toString();
    }
}
