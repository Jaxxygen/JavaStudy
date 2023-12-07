package JSONParser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONStationObject {
    @JsonProperty("station_name")
    String stationName;
    @JsonProperty("depth")
    String depth;

    public JSONStationObject() {
    }

    public String getName() {
        return stationName;
    }

    public String getDepth() {
        return depth;
    }
}
