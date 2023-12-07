package practice.regex;

import java.util.Scanner;

public class SplitText {

  public static void main(String[] args) {
    String text = new Scanner(System.in).nextLine();
    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {
    text = text.replaceAll("[^A-Za-z ]", "");
    String [] words = text.split(" +");
    StringBuilder finalText = new StringBuilder();

    for ( int i = 0; i < words.length; i++) {
      int length = words.length;
      if (i == (length-1)) {
        finalText.append(words[i]);
      } else {
        finalText.append(words[i].concat("\n"));
      }
    }

    return finalText.toString();
  }

}
//TODO реализуйте метод
