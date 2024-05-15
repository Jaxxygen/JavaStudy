import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Station {

    private int stationNumber;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private HashMap<Date, Voter> votersVisited = new HashMap<>();

    public Station(String stationNumber, Date dateTime, Voter voter) {
        this.stationNumber = Integer.parseInt(stationNumber);
        votersVisited.put(dateTime, voter);
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public HashMap<Date, Voter> getVotersVisited() {
        return votersVisited;
    }
}

