package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        boolean toddler = true;

        while (toddler) {
            System.out.println("Введите имя, номер или команду: ");
            String input = scanner.nextLine();

            if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts().toString());
            } else if (phoneBook.nameCorrect(input)) {
                phoneBook.nameCheck(input);
            } else if (phoneBook.phoneCorrect(input)) {
                phoneBook.phoneCheck(input);
            } else {
                System.out.println("Некорректный ввод");
                toddler = false;
            }



        }
    }

}
