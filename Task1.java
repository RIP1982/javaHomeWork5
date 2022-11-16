/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь
несколько телефонов.
 */

import java.util.*;
import java.util.logging.Logger;

public class Task1 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Map<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(123456, "Ivanov Ivan");
        phoneBook.put(234567, "Ivanov Ivan");
        phoneBook.put(345678, "Smirnov Ilya");
        phoneBook.put(456789, "Morgunov Rinat");
        phoneBook.put(567890, "Ryazanov Kiril");
        phoneBook.put(987654, "Sidorov Stepan");
        System.out.printf("Input request(number or people): ");
        String request = (new Scanner(System.in)).nextLine();
        if (request.equals("people")) {
            try {
                System.out.printf("Input phone number: ");
                Integer searchPeople = (new Scanner(System.in)).nextInt();
                logger.info(searchPeople + " -> " + (phoneBook.get(searchPeople)).toString());
            } catch (NullPointerException e) {
                logger.info("Wrong data!");
            }
        } else if (request.equals("number")) {
            System.out.printf("Input LastName & Name: ");
            String searchPhone = (new Scanner(System.in)).nextLine();
            if (phoneBook.equals(searchPhone)) {
                logger.info(searchPhone + ": " + (getKeys(phoneBook, searchPhone)).toString());
            } else {
                logger.info("Wrong data!");
            }
        } else {
            logger.info("Wrong data!");
        }

    }

    public static <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}