package main.java.practice;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static practice.TodoList todoList = new practice.TodoList();


    public static void main(String[] args) {

        System.out.println("Здравствуйте! \n");


        while (true) {
            int index = 0;
            System.out.println("Введите необходимое действие: ");

           String toDo = new Scanner(System.in).nextLine();
           String[] chop = toDo.split(" ",2);
           String command = chop[0];
           chop[0] = "";
           toDo = "";

            if (command.equals("EDIT")) {
                String[] secChop = chop[1].split(" ", 2);
                index = Integer.parseInt(secChop[0]);
                secChop[0] = "";
                for (int i = 0; i < 2; i++) {
                    toDo = toDo.concat(secChop[i]);
                }
            } else if (command.equals("DELETE")) {
                index = Integer.parseInt(chop[1]);
            } else if (!command.equals("LIST")) {
                for (int i = 0; i < 2; i++) {
                    toDo = toDo.concat(chop[i]);
                }

            }

            switch (command) {
                case ("ADD") -> todoList.add(toDo);
                case ("LIST") -> todoList.getTodos();
                case ("EDIT") -> todoList.edit(index, toDo);
                case ("DELETE") -> todoList.delete(index);
                default -> System.out.println("Ошибка ввода!");
            }
        }
    }
        // TODO: написать консольное приложение для работы со списком дел todoList
}