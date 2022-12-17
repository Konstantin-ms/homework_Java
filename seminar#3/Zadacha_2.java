package seminar#3;

import java.util.ArrayList;
import java.util.Random;

// Задача 2. Пусть дан произвольный список целых чисел, удалить из него четные числа.
public class Zadacha_2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            arrList.add(new Random().nextInt(100));
        }
        System.out.println(arrList);
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) % 2 == 0) {
                arrList.remove(i);
                i--;
            }
        }
        System.out.println(arrList);
    }
}
