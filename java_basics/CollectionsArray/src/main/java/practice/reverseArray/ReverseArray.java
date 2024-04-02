package practice.reverseArray;

import java.util.Arrays;

public class ReverseArray {


    public static String[] reverse(String[] strings) {

        int b = strings.length;
        String[] reversedString;
        reversedString = Arrays.copyOf(strings, strings.length);

        for (int i = 0; i < strings.length; i++) {
            strings[i] = reversedString[--b];
        }

        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
        return strings;
    }

}