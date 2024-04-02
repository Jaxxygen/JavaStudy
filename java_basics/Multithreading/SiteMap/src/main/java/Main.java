import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {


        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        UrlsBuilder urlsBuilder = new UrlsBuilder("http://www.skillbox.ru/");
        urlsBuilder.compute();
        Writer writer = new Writer();
        writer.write(urlsBuilder.getAllUrlsSet());

        System.out.println(urlsBuilder);
    }
}
