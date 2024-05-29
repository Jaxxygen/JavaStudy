import java.util.Arrays;
import java.util.Set;
import  java.util.HashSet;

public class Field {
    int[][] field9x9 = new int[9][9];

    public Field() {
        fieldFill();
    }


    public void fieldFill() {

        for (int i = 0; i < field9x9.length; i++) {
            for (int b = 0; b < field9x9.length; b++) {
                int numberOfIterations = 0;
                int randomNumber;
                do {
                    randomNumber = (int) Math.round((Math.random() * 8) + 1);
                    numberOfIterations++;
                    if (numberOfIterations > 100) {
                        clearLine(i);
                        b = 0;
                    }
                } while (isContainsInLine(randomNumber) || isContainsInColumn(randomNumber, b));
                field9x9[i][b] = randomNumber;
            }
        }
        Arrays.stream(field9x9).map(Arrays::toString).forEach(System.out::println);
    }

    //Проверка содержания номера в строке
    public boolean isContainsInLine(int number) {
        for (int[] ints : field9x9) {
            Set<Integer> lineArray = new HashSet<>();
            for (int b = 0; b < field9x9.length; b++) {
                if (ints[b] != 0) {
                    lineArray.add(ints[b]);
                }
            }
            if (!lineArray.add(number) && lineArray.size() < field9x9.length) {
                return true;
            }
        }
        return false;
    }


    //Проверка содержания номера в столбце
    public boolean isContainsInColumn(int number,  int numberOfColumn) {
            Set<Integer> columnArray = new HashSet<>();
        for (int[] ints : field9x9) {
            if (ints[numberOfColumn] != 0) {
                columnArray.add(ints[numberOfColumn]);
            }
        }
        return columnArray.contains(number) && columnArray.size() < field9x9.length;
    }

    public void clearLine(int lineNumber) {
        for (int i = 0; i < field9x9.length; i++) {
            field9x9[lineNumber][i] = 0;
        }
    }

    //Проверка содержания в квадрате 3х3
    public boolean isSquareContains (int number) {
        int[][] square = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int b = 0; b < 3; b++) {
                if (field9x9[i][b] != 0) {
                    square[i][b] = field9x9[i][b];
                }
            }
        }
        return false;
    }
}
