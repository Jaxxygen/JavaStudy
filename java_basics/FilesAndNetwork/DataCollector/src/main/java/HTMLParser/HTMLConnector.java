package HTMLParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

public class HTMLConnector {
    StationsParser stationParser;
    LineParser lineParser;

    public HTMLConnector(String path) {
        try {
            Document doc = Jsoup.connect(path).get();
            stationParser = new StationsParser(doc);
            lineParser = new LineParser(doc);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Map<String, String> getLinesNumbersNamesMap() {
        return lineParser.getLineNumbersNamesMap();
    }
    public Map<String, Map<Integer[], String[]>> getLineNumberStationNumberNameMap() {
        return stationParser.getLineNumberStationNumberNameMap();
    }
    public Map<String, Boolean> getStationsWithConnection() {
        return stationParser.getStationsWithConnection();
    }

    @Override
    public String toString() {
        return lineParser.toString().concat("\n").concat(stationParser.toString());
    }
}
