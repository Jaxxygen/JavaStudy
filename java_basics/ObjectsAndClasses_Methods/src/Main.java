public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");
        System.out.println("Общий вес корзины составляет - " + basket.getTotalWeight() + "\n");

        Basket basket1 = new Basket();
        basket1.add("Печенье", 120, 500, 21);
        basket1.add("Вода", 100);
        basket1.add("Кофе", 250, 2);
        basket1.add("Сливки", 140,2,0.5);
        basket1.print("Печенье");
        System.out.println("Общий вес корзины составляет - " + basket1.getTotalWeight() + "\n");

        System.out.println("\nТеперь займемся вычислениями");
        arithmetic();
    }

    public static void arithmetic() {

        Arithmetic arithmetic = new Arithmetic(2,5);
        System.out.println("Максимальное число - " + arithmetic.max() +
                "\nМинимальное число - " + arithmetic.min() +
                "\nСумма чисел - " + arithmetic.sum() +
                "\nПроизведение чисел - " + arithmetic.multip());
    }
}
