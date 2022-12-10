// Задача 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n).


import java.util.Scanner;

public class work_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число n: ");
        final int number = in.nextInt();        
        int tn = (number*(number+1))/2;         // вычисляем треугольное число
        int fn = 1;
        for (int i = 1; i <= number; i++)       // вычисляем факториал
            fn = i*fn;
        System.out.printf("Треугольное число будет равно: %d\n", tn);
        System.out.printf("Факориал числа будет равен: %d\n", fn);
    }
}
