import java.util.List;

public class Product {


    private final String name;
    private final double price;
    private final double bonus;
    private final String bonusPercent;
    private final double moneyBackFromBonus;
    private final String link;

    public Product(String name, double price, double bonus, String bonusPercent, double moneyBackFromBonus, String link) {
        this.name = name;
        this.price = price;
        this.bonus = bonus;
        this.bonusPercent = bonusPercent;
        this.moneyBackFromBonus = moneyBackFromBonus;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getBonus() {
        return bonus;
    }

    public String getBonusPercent() {
        return bonusPercent;
    }

    public double getMoneyBackFromBonus() {
        return moneyBackFromBonus;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice() + " " +
                getBonus() + " " + getBonusPercent() + " " +
                 getMoneyBackFromBonus() + "\n";
    }
}
