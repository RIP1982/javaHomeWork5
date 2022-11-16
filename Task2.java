/* Пусть дан список сотрудников:
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Task2 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        List<String> employeesList = fillArray();
        Map<String, String> employeesMap = fillMap();
        logger.info(employeesList.toString());
        logger.info(employeesMap.toString());
        logger.info(howManyRepetitions().toString());
    }

    public static Map<String, Integer> howManyRepetitions(){
        Map<String, String> map = fillMap();
        Map<String, Integer> mapRepeat = new HashMap<>();

        for (String name: map.values()) {
            Integer count = 0;
            for (String nameRepeat: map.values()) {
                if (name.equals(nameRepeat)) {
                    count += 1;
                }
                mapRepeat.put(name, count);
            }
        }
        return  mapRepeat;
    }


    public static List<String> fillArray() {
        List<String> arr = new ArrayList<>();
        try {
            File file = new File("src/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            arr.add(line);
            while (line != null) {
                line = reader.readLine();
                arr.add(line);
            }
            arr.remove(arr.size()-1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public static Map<String, String> fillMap() {
        List<String> arr = fillArray();
        Map<String, String> map = new HashMap<>();
        for (String item: arr) {
            String[] names = item.split(" ");
            map.put(names[1], names[0]);
        }
        return map;
    }
}
