import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(2,2,2);
        System.out.println(dimensions);
        Dimensions dimensions1 = dimensions.setHeigh(10);
        System.out.println(dimensions1);

        Cargo cargo = new Cargo(
                dimensions,
                12,
                "Proletarsk St.",
                false,
                "1334a",
                false
        );
        System.out.println(cargo);
        Cargo cargo1 = cargo.setWeight(15)
                .setDeliveryAdress("Lenina St.")
                .setOverTurning(true)
                .setRegistrationNumber("11b")
                .setFragility(true);
        System.out.println(cargo1);
        System.out.println(cargo);
    }
}
/*
public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }
}
*/
