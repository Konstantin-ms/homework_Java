package seminar#2;

import java.io.FileWriter;
import java.io.IOException;

// Задача 2. Реализуйте алгоритм сортировки пузырьком числового массива, результат 
// после каждой итерации запишите в лог-файл.

public class Zadacha_2 {
    public static void main(String[] args) {
        Integer[] mass = { 3, 4, 1, 6, 2, 5 };
        int free_place = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - 1; j++) {
                if (mass[j] > mass[j + 1]) {
                    free_place = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = free_place;
                }
                try (FileWriter my_log = new FileWriter("../Seminar_2/log_Zadacha_2.txt", true)) {
                    my_log.write(mass[j].toString());
                    my_log.flush();
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
            }
            try (FileWriter my_log = new FileWriter("../Seminar_2/log_Zadacha_2.txt", true)) {
                my_log.write(mass[5].toString());
                my_log.append("\n");
                my_log.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }
        for (int i = 0; i < mass.length; i++)
            System.out.print(mass[i] + " ");
    }
}
