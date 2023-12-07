package HTMLParser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    Document document;
    Elements linesTitles;
    private Map<String, String> linesTitelsMap = new HashMap<>();

    public LineParser(Document document) {
        this.document = document;
        linesTitles = document.select("div[data-depend] > span");
        getLineNumbersNamesMap();
    }

    public Map<String, String> getLineNumbersNamesMap() {
        linesTitles.forEach(e -> {
            String lineNumber = e.attr("data-line");
            String lineName = e.text();
            linesTitelsMap.put(lineNumber, lineName);
        });
        return linesTitelsMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> entry : linesTitelsMap.entrySet())
            {
                builder.append("Номер линии: ").append(entry.getKey())
                        .append(" Наименнование линии: ").append(entry.getValue()).append("\n");
            }
        return builder.toString();
    }
}
