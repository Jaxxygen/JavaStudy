package practice;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> list = new ArrayList<>();
    public void add(String todo) {
        list.add(todo);
        System.out.println("Добавлено дело \" " + todo + " \"");
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        if (index <= list.size()) {
            list.add(index, todo);
            System.out.println("Добавлено дело \" " + todo + " \"");
        } else {
            list.add(todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(int index, String todo) {
        if (index <= list.size()) {
            String e = list.get(index);
            list.set(index, todo);
            System.out.println("Дело \"" + e + "\" изменено на \"" + todo + "\"" );
        } else {
            System.out.println("Такой номер отсутствует в списке");
        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if (index < list.size()) {
            System.out.println(index);
            list.remove(index);
            System.out.println("Удалено дело № " + index);
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        int num = 0;
        for (String todos : list) {
            System.out.println(num + " - " + todos);
            num++;
        }
        // TODO: вернуть список дел
        return list;
    }

}