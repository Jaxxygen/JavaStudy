public class Main {
    public static void main(String[] args) {
/*        Basket basket = new Basket();
        basket.add("Клубника", 100, 2);
        basket.add("Персик", 100, 2);
        System.out.println(Basket.getTotalBasketsPrice() + "\n" + Basket.getTotalItemsAmount());

        Basket basket1 = new Basket();
        basket1.add("Лимонад", 120, 2);
        basket1.add("Эклеры", 50, 4);
        System.out.println(Basket.getTotalBasketsPrice() + "\n" +
                "Общее количество товаров в корзинах: " + Basket.getTotalItemsAmount() + "\n" +
                "Средняя цена товара: " + Basket.middlePrice() + "\n" +
                "Средняя стоимость корзины: " + Basket.middleBasketsPrice());
    }
 */
        Computer computer = new Computer("MSI", "Katana",
                new Processor(2.8, 8, ProcessorManufacturer.INTEL, 0.08),
                new Ram(RamType.DDR4, 64, 0.1),
                new StorageDevice(StoageDeviceType.SSD, 500, 0.2),
                new Screen(17, ScreenType.TN, 0.5),
                new Keyboard(KeyboardType.MECHANICAL, true, 1.1));
        System.out.println(computer);
        computer.setScreen(new Screen(13, ScreenType.IPS, 0.2));
        System.out.println(computer);
    }
}
