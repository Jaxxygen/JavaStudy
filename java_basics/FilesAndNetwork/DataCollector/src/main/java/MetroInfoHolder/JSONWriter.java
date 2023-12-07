package MetroInfoHolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.*;

public class JSONWriter {

    public void writeJSONLineList(ArrayList<Line> lineList) {
        JSONObject jsonObject = new JSONObject();
        lineList.forEach(line -> {
            List<String> stationsNames = new ArrayList<>();
            line.getStations().forEach(station -> stationsNames.add(station.getStationName()));
            jsonObject.put(line.getLineNumber(), stationsNames);
        });
        try {
            FileWriter file = new FileWriter("data/Lines.json");

            file.write(jsonObject.toJSONString());
            file.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void writeJSONStationList(ArrayList<Line> lineList) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Station> stationList = new ArrayList<>();
        lineList.forEach(line -> stationList.addAll(line.getStations()));
        try {
            FileWriter file = new FileWriter("data/Stations.json");
            objectMapper.writeValue(file, stationList);
            file.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }




}
