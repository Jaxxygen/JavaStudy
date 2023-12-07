package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();
        int boxesLeft = 1;
        int trucks = 0;
        int containers = 0;
        int boxesAmount = 0;

        for (int trucksAmount = 0; boxes > 0 ; trucksAmount++) {
            trucks++;
            System.out.println("Грузовик: " + trucks);                                                  //Вкладываем контейнеры в грузовик
            for (int containersLeft = 1; containersLeft <= 12 && boxes > 0; containersLeft++) {         //Вкладываем коробки в контейнеры
                containers++;
                System.out.println("\t" + "Контейнер: " + containers);
                if (boxes / 27 >= 1) {                                                                  //Определяем, хватит ли одного контейнера для коробок
                    for (int boxesInContainer = 1; boxesInContainer <= 27 && containersLeft <= 12; boxesInContainer++) {
                        boxesAmount++;
                        System.out.println("\t\t" + "Ящик: " + boxesAmount);
                    }
                } else {
                        for (boxes = boxes % 27; boxesLeft <= boxes; boxesLeft++) {                      //Если одного контейнера хватит
                            boxesAmount++;
                            System.out.println("\t\t" + "Ящик: " + boxesAmount);
                            if (boxes == boxesLeft) {
                                break;
                            }
                        }
                }
                boxes = boxes - 27;
            }
        }
        System.out.println("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + trucks + " шт.\n" +
                "контейнеров - " + containers + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
