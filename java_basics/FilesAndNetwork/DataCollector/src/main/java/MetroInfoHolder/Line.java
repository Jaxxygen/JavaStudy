package MetroInfoHolder;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
@JsonSerialize
@JsonAutoDetect
public class Line {

    String lineName;
    String lineNumber;

    ArrayList<Station> stations = new ArrayList<>();

    public Line(String lineName, String lineNumber, Station station) {
        this.lineName = lineName;
        this.lineNumber = lineNumber;
        this.stations.add(station);
    }
    public Line(String lineName, String lineNumber, ArrayList<Station> stations) {
        this.lineName = lineName;
        this.lineNumber = lineNumber;
        this.stations.addAll(stations);
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public String getLineName() {
        return lineName;
    }

    public String getLineNumber() {
        return lineNumber;
    }
}
