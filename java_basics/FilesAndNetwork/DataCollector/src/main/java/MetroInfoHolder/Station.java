package MetroInfoHolder;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonAutoDetect
public class Station {

    private String stationName;
    private String line;
    private String depth;
    private String date;
    private boolean hasConnection;

    public Station(String stationName, String line, String depth, String date, boolean hasConnection) {
        this.stationName = stationName;
        this.line = line;
        this.depth = depth;
        this.date = date;
        this.hasConnection = hasConnection;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    public String getStationName() {
        return stationName;
    }

    public String getLine() {
        return line;
    }

    public String getDepth() {
        return depth;
    }

    public String getDate() {
        return date;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }
}
