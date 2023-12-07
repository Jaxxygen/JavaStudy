package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

  public static void main(String[] args) {

    boolean condition = true;
    Scanner scanner = new Scanner(System.in);

    while (condition) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        System.out.println("Неверный формат номера");
        scanner.close();
        break;
      }
      input = input.replaceAll("[^0-9]", "");
      String regex = "[7][0-9]{10}";
      String secondRegex = "[0-9]{10}";
      String thirdRegex = "[8][0-9]{10}";
      String fourthRegex = "[^7-8][0-9]{10}";

      if (input.matches(secondRegex)) {
        input = "7".concat(input);
        System.out.println(input);
        condition = false;
      } else if (input.matches(thirdRegex)) {
        input = input.replaceFirst("8", "7");
        System.out.println(input);
        condition = false;
      } else if (input.matches(regex)) {
        System.out.println(input);
        condition = false;
      } else if (input.matches(fourthRegex)) {
        input = "Неверный формат номера";
        System.out.println(input);
        condition = false;
      } else {
        input = "Неверный формат номера";
        System.out.println(input);
        condition = false;
      }

      // TODO:напишите ваш код тут, результат вывести в консоль.
    }
  }

}
