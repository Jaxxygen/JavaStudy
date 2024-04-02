public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());



        for (int i = 0; i < 65536; i++) {
            if (i >= (int) 'А' && i <= (int) 'я') {
                char c = (char) i;
                System.out.println(i + " - " + c);
            } else if (i == (int) 'ё' || i == (int) 'Ё') {
                char c = (char) i;
                System.out.println(i + " - " + c);
            }
        }

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
