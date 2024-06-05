import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatter {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();

        ArrayList<String> list = new ArrayList<>();

        String text = str.replace(",", " ");
        String regex = "[a-z]+\\W";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        while (match.find()) {
            int start = match.start();
            int end = match.end();
            list.add(str.substring(start, end).trim());
        }

        

        String[] strLengthArr = pattern.split(text);

        //Определение самого длинного слова в переданном тексте
        int i = 0;
        for (String s : strLengthArr) {
            if (s.length() > i) {
                i = s.length();
            }
        }

        //Выстраивание строки
        int len = i*3;
        String[] strArr = pattern.split(str);
        String result = "";

        int counter = 0;
        int spaceLength = 1;
        for (int a = 0; a < strArr.length; a++) {
            if (strArr[a].isEmpty()) {
                continue;
            }
            if (counter + strArr[a].length() <= len) {
                if (counter + strArr[a].length() + spaceLength == len || a + 1 == strArr.length) {
                    result = result.concat(strArr[a]);
                    counter += (strArr[a].length() + spaceLength);
                } else {
                    result = result.concat(strArr[a]).concat(" ");
                    counter += (strArr[a].length() + spaceLength);
                }
            } else {
                result = result.trim();
                result = result.concat("\n").concat(strArr[a]).concat(" ");

                counter = (strArr[a].length() + spaceLength);
            }
        }
        System.out.println(result);
    }
}
