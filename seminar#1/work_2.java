// Задача 2. Вывести все простые числа от 1 до 1000

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work_2 {
    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);

        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {        
        Integer[] simpleNumber = { 2, 3 };

        for (int number = 5; number <= 1000; number++) {
            int count = 0;
            for (int index = 0; index <= simpleNumber.length-1; index++) {
                if (number % simpleNumber[index] != 0) {
                    count++;
                    if (count == simpleNumber.length)
                        simpleNumber = append(simpleNumber, number);
                }
            }
        }

        System.out.println(Arrays.toString(simpleNumber));
    }
}