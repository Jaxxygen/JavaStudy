public class Basket {
    private static int count = 0;

    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalBasketsPrice = 0; // общая цена корзины
    private static int totalItemsAmount = 0; // общее количество товаров
    private static int basketsCount = 0; // количество корзин

    public Basket() {
        increaseCount(1);
        increaseBaskets();
        items = "Список товаров:";
        this.limit = 10000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }


    public static int getCount() {
        return count;
    }

    public static int getTotalBasketsPrice() {
        return totalBasketsPrice;
    }

    public static int getTotalItemsAmount() {
        return totalItemsAmount;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }
    public static void increaseTotalAmount(int amount) {
        Basket.totalItemsAmount = Basket.totalItemsAmount + amount;
    }
    public static void increaseTotalBasketsPrice(int totalPrice) {
        Basket.totalBasketsPrice = Basket.totalBasketsPrice + totalPrice;
    }
    private static void increaseBaskets() {
        basketsCount = basketsCount + 1;
    }
    public static int middleBasketsPrice() {
        int middleBasketsPrice = totalBasketsPrice / basketsCount;
        return middleBasketsPrice;
    }
    public static int middlePrice() {
        int middlePrice = Basket.totalBasketsPrice/Basket.totalItemsAmount;
        return middlePrice;
    }


    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + (count * price);
        increaseTotalAmount(1);
        increaseTotalBasketsPrice(count * price);
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price);
        totalWeight = totalWeight + weight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
