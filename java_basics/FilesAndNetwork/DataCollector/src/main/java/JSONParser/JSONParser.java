package JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class JSONParser {

    List<JSONStationObject> jsonObject;
    Map<String, String> stringMap = new TreeMap<>();


    public JSONParser(String path) throws Exception {
        String json = Files.readString(Paths.get(path));
        ObjectMapper mapper = new ObjectMapper();
        jsonObject = mapper.readValue(json, new TypeReference<>(){});
    }

    public Map<String, String> getStationsNameDepthMap() {
        jsonObject.forEach(e -> stringMap.put(e.getName(), e.getDepth()));
        return stringMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        jsonObject.forEach(obj -> builder.append("Станция: ").append(obj.getName())
                .append(" Глубина:").append(obj.getDepth()).append("\n"));
        return builder.toString();
    }
}
