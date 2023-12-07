import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class InfoCollector {
    private List<Product> productList = new ArrayList<>();

    public InfoCollector(String line) {
        Document doc = Jsoup.parse(line);
        Elements elements = doc.select("div[data-product-id]");

        elements.forEach(e -> {
            Product product = new Product(getProductName(e), getPrice(e),getBonus(e),getBonusPercent(e), (getBonus(e)*0.79), getLink(e));
            productList.add(product);
        });
    }

    private String getProductName(Element element) {
        Elements name = element.select("a[title]");

        return name.attr("title");
    }

    private Double getPrice(Element element) {
        Elements line = element.select("div.item-price span");
        String price = line.text().replaceAll("[^0-9]", "");
        return Double.parseDouble(price);
    }

    private Double getBonus(Element element) {
        Elements bonus = element.select("span.bonus-amount");
        String bonusFilter = bonus.text().replaceAll("[^0-9]", "");
        return Double.parseDouble(bonusFilter);
    }
    private String getBonusPercent(Element element) {
        Elements bonusPercent = element.select("span.bonus-percent");

        return bonusPercent.text();
    }
    private String getLink(Element element) {
        Elements link = element.select("a[href]");
        String htmlLink = "https://megamarket.ru" + link.attr("href");
        return htmlLink;
    }

    public List<Product> getProductList() {
        return productList;
    }


    @Override
    public String toString() {
        return productList.toString();
    }
}
