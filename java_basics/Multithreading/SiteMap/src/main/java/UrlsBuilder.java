import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class UrlsBuilder extends RecursiveTask<Set<String>> {

    private static final Set<String> allUrlsSet = new HashSet<>();
    private static final Set<String> checkUrlsSet = new HashSet<>();
//    private static final Writer writer = new Writer();
//    private static final long startTime = System.currentTimeMillis();

    private static String root;
    private int count = 0;
    String url;

    public UrlsBuilder(String url) {
        this.url = url;
        if (count == 0) {
            root = url.substring(0, url.length() - 1);
            count++;
        }
    }

    public String getAllUrlsSet() {
        StringBuilder stringBuilder = new StringBuilder();
        allUrlsSet.forEach(s -> stringBuilder.append(s).append("\n"));
        return stringBuilder.toString();
    }

    public synchronized void addUrlToAllUrlsSet(String url) {
        UrlsBuilder.allUrlsSet.add(url);
        checkUrlsSet.add(url.replaceAll("\t", ""));
//        writer.write(url);
    }


    public Set<String> parseUrl (String url) {
        Set<String> urlsList = new HashSet<>();
        try {
        Document document;
        Elements elements;
            document = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get();

        elements = document.select("a[href]");

        elements.forEach(el -> {
            String newUrl = root.concat(el.attr("href"));
            String regex = root.replaceAll("/", "\\/").concat("/.*");
            if (newUrl.matches(regex) && newUrl.endsWith("/") && !checkUrlsSet.contains(newUrl)) {
                urlsList.add("\t".concat(newUrl));
            }
        });
            Thread.sleep(100);
        } catch (IOException | InterruptedException ex) {
            ex.getMessage();
            return urlsList;
        }
        return urlsList;
    }


    @Override
    protected Set<String> compute() {
        List<UrlsBuilder> tasks = new ArrayList<>();
        Set<String> result = new HashSet<>();
            addUrlToAllUrlsSet(url);
            parseUrl(url).forEach(s -> {
                UrlsBuilder urlsBuilder = new UrlsBuilder(s);
                urlsBuilder.fork();
                tasks.add(urlsBuilder);
            });
        tasks.forEach(t -> result.addAll(t.join()));
        return result;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        allUrlsSet.forEach(s -> stringBuilder.append(s).append('\n'));
        return stringBuilder.toString();
    }


    //    public long getStartTime() {
//        return startTime;
//    }

//    @Override
//    public int compareTo(UrlsBuilder o) {
//        if (this.getStartTime() > o.getStartTime()) {
//            return 1;
//        } else if (this.getStartTime() < o.getStartTime()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
