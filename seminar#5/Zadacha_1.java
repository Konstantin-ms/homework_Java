package seminar#5;

// Задача 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 
// человек может иметь несколько телефонов.

import java.util.HashMap;
import java.util.Scanner;


public class Zadacha_1 {
    public static void main(String[] args) {
        HashMap<String, String> tbook = new HashMap<>();
        tbook.put("89235552111", "Ivanov Ivan Ivanovich");
        tbook.put("89134550809", "Ivanov Ivan Ivanovich");
        tbook.put("89153452122", "Petrov Ivan Alekseevich");
        tbook.put("89231554343", "Deev Sergey Ivanovich");
        tbook.put("89881150000", "Dubinin Oleg Valentinovich");
        tbook.put("89024321111", "Petrov Ivan Alekseevich");
        tbook.put("89035350011", "Egorov Vasiliy Petrovich");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО для поиска телефона: ");
        String full_name = scan.nextLine();
        String key = "";
        for (String num : tbook.keySet()) {                          
            if (tbook.get(num).equals(full_name)){
                key = num;
                System.out.println(key);
            }
        }
    }
}