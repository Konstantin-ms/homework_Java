package seminar#5;

import java.util.HashMap;
import java.util.Map;

// Задача 2. Пусть дан список сотрудников. Написать программу, которая найдет и выведет 
// повторяющиеся имена с  количеством повторений. Отсортировать по убыванию популярности.

public class Zadacha_2 {
    public static void main(String[] args) {
        String[] list = { "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
                "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
                "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин",
                "Иван Ежов" };
        HashMap<String, String> surname = new HashMap<>();
        HashMap<String, Integer> name = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String[] text = list[i].split(" ");
            surname.put(text[1], text[0]);
        }
        for (String i : surname.keySet()) {
            int count = 0;
            for (String j : surname.keySet()) {
                if (surname.get(i).equals(surname.get(j))) {
                    count++;
                }
            }
            if (count > 1) {
                name.put(surname.get(i), count);
            }
        }
        name.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
