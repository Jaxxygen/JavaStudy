package practice;

import java.util.*;

public class PhoneBook {

    private final TreeMap<String, String> phoneBook = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);
    private boolean sameNames = false;


    public void addContact(String phone, String name) {
// проверьте корректность формата имени и телефона
// (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
// если такой номер уже есть в списке, то перезаписать имя абонента
        if (phoneCorrect(phone) && nameCorrect(name)) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.remove(phone);
            } else {
                if (phoneBook.containsValue(name)) {
                    sameNames = true;
                }
            }
            phoneBook.put(phone, name);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("некорректный формат ввода");
        }


    }

    public boolean nameCorrect(String name) {
        String regex = "[A-Za-zА-Яа-яЁё]+";
        return name.matches(regex);
    }

    public void nameCheck(String name) {
// Если введено имя, которое есть в адр. книге, выводится на печать имя-номер,
// в обратном случае запрашивается номер телефона для имени и
// если корректен, добавляется в адресную книгу
        if (phoneBook.containsValue(name)) { // Наличие имени в адр. книге
            System.out.println("Контакт ".concat(name).concat(" имеется в телефонной книге"));
            getContactByName(name);
        } else {
            System.out.println("Введите номер телфона для имени ".concat(name));
            String phone = scanner.nextLine(); // Запрос ввода телефона
            if (phoneCorrect(phone) && !phone.isEmpty()) {
                addContact(phone, name);
            } else {
                System.out.println("Формат введенного номера некорректен");
            }
        }
    }

    public boolean phoneCorrect(String phone) {
        String regex = "[78][0-9]{10}";
        return phone.matches(regex);
    }

    public void phoneCheck(String phone) {
// Если адр. книга содержит телефон, возвращается имя-телефон
// если наоборот, для этого телефона принимается имя и проверяется на корректность ввода
// если имя корректно, оно добавляется в адр. книгу
        if (phoneBook.containsKey(phone)) {
            System.out.println("Введенный номер имеется в адресной книге");
            getContactByPhone(phone);
        } else {
            System.out.println("Введите имя для абонента ".concat(phone).concat(" :"));
            String name = scanner.nextLine();
            if (nameCorrect(name) && !name.isEmpty()) {
                addContact(phone, name);
            } else {
                System.out.println("Формат введенного имени некорректен");
            }
        }
    }


    public String getContactByPhone(String phone) {
// формат одного контакта "Имя - Телефон"
// если контакт не найдены - вернуть пустую строку
        return phoneBook.get(phone).concat(" - ").concat(phone);
    }

    public Set<String> getContactByName(String name) {
// формат одного контакта "Имя - Телефон"
// если контакт не найден - вернуть пустой TreeSet
        Set<String> list = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            // перебор адресной книги для поиска имени
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения значения
            if (value.equals(name)) {
                // если имя найдено, кладет его в TreeSet
                String form = (value.concat(" - ").concat(key));
                list.add(form);
            }
        }
        return list;
    }

    public Set<String> getAllContacts() {
// формат одного контакта "Имя - Телефон"
// если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (phoneBook.isEmpty()) {
            return new TreeSet<>();
        } else {
            TreeSet<String> list = new TreeSet<>();
            TreeMap<String,String> clone = new TreeMap<>();
            clone.putAll(phoneBook);
            // Создаем копию адр. книги
            if (sameNames) {
                // Условие на наличие одинаковых имен
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    // перебираем ключи и значения адр. книги
                    String key = entry.getKey();
                    String value = entry.getValue();
                    for (Map.Entry<String, String> entry2 : clone.entrySet()) {
                        // Перебираем ключи и значения клона адр. книги
                        String key2 = entry2.getKey();
                        String value2 = entry2.getValue();
                        if (key.equals(key2)) {
                            // Проверка на одинаковые ключи
                            continue;
                        }
                        if (value.equals(value2)) {
                            // Условие если имена одинаковые, а телефоны разные
                            list.add(value.concat(" - ").concat(key).concat(", ").concat(key2));
                            clone.remove(key);
                        } else {
                            //Обычное составление строки
                            list.add((value.concat(" - ").concat(key)));
                        }
                    }
                }
            } else {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey(); // получения ключа
                    String value = entry.getValue(); // получения значения
                    list.add((value.concat(" - ").concat(key)));
                }

            }
            return list;
        }
    }
}

// для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
// это поможет вам найти все ключи (key) по значению (value)
/*
for (Map.Entry<String, String> entry : map.entrySet()){
String key = entry.getKey(); // получения ключа
String value = entry.getValue(); // получения ключа
}
*/