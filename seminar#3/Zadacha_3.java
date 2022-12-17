package seminar#3;

import java.util.ArrayList;
import java.util.Random;

// Задача 3. Задан целочисленный список ArrayList. Найти минимальное, 
// максимальное и среднее из этого списка. Формат сдачи: файл с расширением 
// java или ссылка на гит с подписанными ФИ и номером группы.

public class Zadacha_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrListNumber = new ArrayList<Integer>(20);
        int arrSize = 20;
        for (int i = 0; i < arrSize; i++) {
            arrListNumber.add(new Random().nextInt(100));
        }
        System.out.println(arrListNumber);
        int max = 0;
        int min = arrListNumber.get(0);        
        int sum = 0;        
        for (int i = 0; i < arrListNumber.size(); i++) {
            if (arrListNumber.get(i) > max) {
                max = arrListNumber.get(i);
            } else if (arrListNumber.get(i) < min) {
                min = arrListNumber.get(i);
            }
            sum += arrListNumber.get(i);
        }
        int sr_arifm = 0;
        int middle = arrListNumber.get(0);
        sr_arifm = sum / arrSize;        
        for (int i = 1; i < arrListNumber.size(); i++) {
            if (Math.abs(middle - sr_arifm) >= Math.abs(arrListNumber.get(i) - sr_arifm)) 
                middle = arrListNumber.get(i);            
        }
        System.out.println("Минимальное число из списка: " + min);
        System.out.println("Максимальное число из списка: " + max);        
        System.out.println("Среднее число из списка: " + middle);
    }
}