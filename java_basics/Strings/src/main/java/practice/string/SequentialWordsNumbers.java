package practice.string;

public class SequentialWordsNumbers {

    public static void main(String[] args) {
        String text = "слово";
        System.out.println(sequentialWordsNumbers(text));
    }

    public static String sequentialWordsNumbers(String text){
        StringBuilder finalText = new StringBuilder();
        int number = 1;
        int index = 0;
        String string;

        for (int i = 0; i < text.length();) {

            int startIndex = index;
            index = text.indexOf(" ",i);
            String numberForm = "("
                    .concat(Integer.toString(number))
                    .concat(")");

            if (index == -1) {
                if (number == 1) {
                    string = numberForm
                            .concat(" ")
                            .concat(text.substring(startIndex));
                } else {
                    string = numberForm
                            .concat(text.substring(startIndex));
                }
                finalText.append(string);
                break;
            } else {
                if (number == 1) {
                    string = numberForm
                            .concat(" ")
                            .concat(text.substring(startIndex, index + 1));
                } else {
                    string = numberForm
                            .concat(text.substring(startIndex, index + 1));
                }
            }
            i = index + 1;
            number = number + 1;
            finalText.append(string);
        }
        return finalText.toString();
    }
}
