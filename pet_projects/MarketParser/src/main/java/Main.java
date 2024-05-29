import org.jsoup.Jsoup;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String htmlFile = ParseFile.parseFile("data/PageCode2.html");
        TableFormatter tablesFormatter = new TableFormatter(htmlFile);
    }


}
