package practice;

import java.util.*;

public class CoolNumbers {
    public static List<String> generateCoolNumbers() {
        List<String> numbers = new ArrayList<>();
        String zero = "0";
        for (int i = 0; i < 3_000_000; i++) {
// генерация трех чисел
            String values;
            Integer intValues = (int) Math.round(Math.random() * 1000);
            if (intValues <= 99) {
                values = zero.concat(intValues.toString());
                if (intValues <= 9) {
                    values = zero.concat(values);
                }
            } else {
                values = intValues.toString();
            }
// генерация региона
            String region = "";
            Integer intRegion = (int) Math.round(1 + (Math.random() * 199));
            if (intRegion <= 9) {
                region = zero.concat(intRegion.toString());
            } else {
                region = intRegion.toString();
            }
// генерация букв
            Collections.shuffle(letters());
            String x = letters().get(0);
            String y = letters().get(1);
            String z = letters().get(2);

//составление номера
            numbers.add(x.concat(values).concat(y).concat(z).concat(region));
        }
        return numbers;
    }
    public static ArrayList<String> letters() {
        ArrayList<String> lettersList = new ArrayList<>();
        lettersList.add("А");
        lettersList.add("В");
        lettersList.add("Е");
        lettersList.add("К");
        lettersList.add("М");
        lettersList.add("Н");
        lettersList.add("О");
        lettersList.add("Р");
        lettersList.add("С");
        lettersList.add("Т");
        lettersList.add("У");
        lettersList.add("Х");

        return lettersList;
    }


    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long startTime = System.nanoTime();
        for (String s : list) {
            if (number.equals(s)) {
                long endTime = System.nanoTime();
                System.out.println("Поиск перебором: номер найден, поиск занял "
                        .concat(String.valueOf(endTime - startTime)).concat(" нс"));
                return true;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Поиск перебором: номер ненайден, поиск занял "
                .concat(String.valueOf(endTime - startTime)).concat(" нс"));
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0) {
            long endTime = System.nanoTime();
            System.out.println("Бинайрный поиск: номер найден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return true;
        } else {
            long endTime = System.nanoTime();
            System.out.println("Бинарный поиск: номер ненайден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return false;
        }
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();
        if (hashSet.contains(number)) {
            long endTime = System.nanoTime();
            System.out.println("Поиск по хэшу: номер найден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return true;
        } else {
            long endTime = System.nanoTime();
            System.out.println("Поиск по хэшу: номер ненайден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return false;
        }
    }


    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();
        if (treeSet.contains(number)) {
            long endTime = System.nanoTime();
            System.out.println("Поиск по дереву: номер найден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return true;
        } else {
            long endTime = System.nanoTime();
            System.out.println("Поиск по дерву: номер ненайден, поиск занял "
                    .concat(String.valueOf(endTime - startTime)).concat(" нс"));
            return false;
        }
    }

}
