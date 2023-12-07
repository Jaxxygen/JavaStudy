import org.apache.logging.log4j.*;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final Marker ERROR_MARKER = MarkerManager.getMarker("ERROR_MARKER");
    private static final Marker INPUT_MARKER = MarkerManager.getMarker("INPUT_HISTORY");


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws CustomerException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        try {
            String[] components = data.split("\\s+");
            checkCustomerStorage(components);
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
            LOGGER.info(INPUT_MARKER, "Пользователь добавил клиента: " + data);
        } catch (CustomerException exception) {
            LOGGER.info(ERROR_MARKER,"Ошибка добавления клиента: " + data);
            throw exception;
        }
    }

    public void listCustomers() {
        LOGGER.info(INPUT_MARKER,"Пользователь вызвал список клиентов");
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        LOGGER.info(INPUT_MARKER,"Пользователь удалил клиента по имени: " + name);
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        LOGGER.info(INPUT_MARKER,"Пользователь вызвал клиента по имени: " + name);
        return storage.get(name);
    }

    public int getCount() {
        LOGGER.info(INPUT_MARKER,"Пользователь вызвал количество клиентов");
        return storage.size();
    }
    private void checkCustomerStorage(String[] array) throws CustomerException {

        if (array.length != 4) {
            LOGGER.info(ERROR_MARKER,"Слишком много/мало слов");
            throw new CustomerException("Некорректный формат ввода данных");
        }
        if (!array[0].matches("[A-za-zА-Яа-яЁё]+")) {
            LOGGER.info(ERROR_MARKER,"Некорректный формат имени");
            throw new CustomerException("Некорректный формат имени");
        }
        if (!array[1].matches("[A-za-zА-Яа-яЁё]+")) {
            LOGGER.info(ERROR_MARKER,"Некорректный формат фамилии");
            throw new CustomerException("Некорректный формат фамилии");
        }
        if (!array[2].contains("@")) {
            LOGGER.info(ERROR_MARKER,"Некорректный формат e-mail");
            throw new CustomerException("Неверный формат e-mail");
        }
        if (!array[3].matches("\\+7[0-9]{10}")) {
            LOGGER.info(ERROR_MARKER,"Некорректный формат телефона");
            throw new CustomerException("Некорректный формат телефона");
        }
    }
}