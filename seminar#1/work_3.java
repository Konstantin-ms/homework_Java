// Задача 3. Реализовать простой калькулятор


import java.util.Scanner;


public class work_3 {
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
            default:  System.out.printf("Введена некорректная операция, попробуйте снова");
                return;
        }
        System.out.print("\nРезультат:\n");
        System.out.printf(num1 + " " + op + " " + num2 + " = " + result);
        
    }
    
}
