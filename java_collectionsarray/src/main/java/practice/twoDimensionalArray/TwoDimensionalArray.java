package main.java.practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        StringBuilder result = new StringBuilder();

        char[][] mark = new char[size][size];
          for (int row = 0; row < size; row++) {
              for (int cell = 0; cell < size; cell++) {
                  if (row == cell || (cell + row) == (size - 1)) {
                      mark[row][cell] = SYMBOL;
                      result.append(mark[row][cell]);
                      if (cell == size - 1) {
                          result.append('\n');
                      }
                  } else {
                      mark[row][cell] = ' ';
                      result.append(mark[row][cell]);
                      if (cell == size - 1) {
                          result.append('\n');
                      }
                  }
              }
          }
        System.out.println(result);
        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return mark;
    }
}
