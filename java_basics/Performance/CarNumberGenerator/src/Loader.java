import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();


        int regionCode = 100;
        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int numbersAmount = 500;
        PrintWriter writer = new PrintWriter("res/numbers.txt");

            for (int number = 1; number < numbersAmount; number++) {

                int finalNumber = number;
                Thread thread = new Thread(() -> {
                    StringBuffer buffer = new StringBuffer();
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                buffer.append(firstLetter);
                                buffer.append(padNumber(finalNumber, 3));
                                buffer.append(secondLetter);
                                buffer.append(thirdLetter);
                                buffer.append(padNumber(regionCode, 2));
                                buffer.append('\n');
                            }
                        }
                    }
                    writer.write(buffer.toString());
                });
                thread.start();
                thread.join();
            }
        writer.flush();
        writer.close();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(number);
        int padSize = numberLength - builder.length();

        builder.reverse();
        for (int i = 0; i < padSize; i++) {
            builder.append(0);
        }
        builder.reverse();

        return builder.toString();
    }
}
