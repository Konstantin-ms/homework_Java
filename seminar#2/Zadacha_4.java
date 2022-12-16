package seminar#2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Задача 4. К калькулятору из предыдущего ДЗ добавить логирование.

public class Zadacha_4 {
    public static void main(String[] args) {
        double num1;
        double num2;
        double result;
        char op;
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите последовательно два числа:\n");
        num1 = reader.nextDouble();
        num2 = reader.nextDouble();
        System.out.print("\nВведите математическую оперцию с указанными числами (+, -, *, /): ");
        op = reader.next().charAt(0);
        switch(op) {
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/': result = num1 / num2;
                break;
            default:  System.out.printf("Введена некорректнаяоперация, попробуйте снова");
                return;
        }
        System.out.print("\nРезультат:\n");
        System.out.printf(num1 + " " + op + " " + num2 + " = " + result);   
        try (FileWriter my_log = new FileWriter("../Seminar_2/log_calc.txt", true)) {
            my_log.write(num1 + " " + op + " " + num2 + " = " + result + "\n");
            my_log.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }     
    }
}
