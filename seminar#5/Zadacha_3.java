package seminar#5;

import java.util.Scanner;

// Задача 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class Zadacha_3 {

    static void heapify(int arr[], int k, int i) {
        int free = 0;
        while (k < i) {
            if (k < (i + 1) / 2 - 1 && arr[k] > arr[2 * k + 1]
                    && arr[2 * k + 2] > arr[2 * k + 1]) {
                free = arr[k];
                arr[k] = arr[2 * k + 1];
                arr[2 * k + 1] = free;
                k = 2 * k + 1;
            } else if (k < (i + 1) / 2 - 1 && arr[k] > arr[2 * k + 2]
                    && arr[2 * k + 1] > arr[2 * k + 2]) {
                free = arr[k];
                arr[k] = arr[2 * k + 2];
                arr[2 * k + 2] = free;
                k = 2 * k + 2;
            } else if (k == i / 2 - 1 && arr[k] > arr[2 * k + 1]) {
                free = arr[k];
                arr[k] = arr[2 * k + 1];
                arr[2 * k + 1] = free;
                k = 2 * k + 1;
            } else
                k = 2 * k + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите неупорядоченный массив чисел: ");
        String myStr = scan.nextLine();
        String strArr[] = myStr.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++)
            numArr[i] = Integer.parseInt(strArr[i]);
        // 1 этап сортировки
        for (int index = numArr.length / 2 - 1; index >= 0; index--)
            heapify(numArr, index, numArr.length);
        // 2 этап сортировки
        for (int index = numArr.length - 1; index > 0; index--) {
            int pik = 0;
            pik = numArr[index];
            numArr[index] = numArr[0];
            numArr[0] = pik;
            heapify(numArr, 0, index);
        }
        // Вывод отсортированного массива
        for (int i = 0; i < numArr.length; i++)
            System.out.print(numArr[i] + " ");
    }
}
