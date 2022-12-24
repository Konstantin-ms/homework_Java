package seminar#5;

// Задача 4. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class Zadacha_4 {
    static int total = 0;
    public static void main(String[] args) {
        System.out.println(GetQueenCombination());
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static int GetQueenCombination() {
        total = 0;        
        boolean flags[] = new boolean[8];
        int array[][];
        array = fun_reference_array(flags);
        if (false) {
            for (boolean i1 : flags) 
                System.out.println(i1);            
            show_array(array);
        }
        int matrix_array[][] = new int[array.length - 1][array[0].length];
        fun_initiation_array_1(matrix_array, 0);
        if (false)
            show_array(matrix_array);
        int matrix_diagonal_array[][] = new int[array.length - 1][array[0].length + array[0].length - 1];
        if (true)
            if (flags[0])
                for (int i1 = 0; i1 < array.length; i1++) {
                    if (!flags[1])
                        if (total_function(array, matrix_array, matrix_diagonal_array, i1))
                            continue;
                    if (flags[1])
                        for (int i2 = 0; i2 < array.length; i2++) {
                            if (!flags[2])
                                if (total_function(array, matrix_array, matrix_diagonal_array, i1, i2))
                                    continue;
                            if (flags[2])
                                for (int i3 = 0; i3 < array.length; i3++) {
                                    if (!flags[3])
                                        if (total_function(array, matrix_array, matrix_diagonal_array, i1, i2, i3))
                                            continue;
                                    if (flags[3])
                                        for (int i4 = 0; i4 < array.length; i4++) {
                                            if (!flags[4])
                                                if (total_function(array, matrix_array, matrix_diagonal_array, i1, i2,
                                                        i3, i4))
                                                    continue;
                                            if (flags[4])
                                                for (int i5 = 0; i5 < array.length; i5++) {
                                                    if (!flags[5])
                                                        if (total_function(array, matrix_array, matrix_diagonal_array,
                                                                i1, i2, i3, i4, i5))
                                                            continue;
                                                    if (flags[5])
                                                        for (int i6 = 0; i6 < array.length; i6++) {
                                                            if (!flags[6])
                                                                if (total_function(array, matrix_array,
                                                                        matrix_diagonal_array, i1, i2, i3, i4, i5, i6))
                                                                    continue;
                                                            if (flags[6])
                                                                for (int i7 = 0; i7 < array.length; i7++) {
                                                                    if (!flags[7])
                                                                        if (total_function(array, matrix_array,
                                                                                matrix_diagonal_array, i1, i2, i3, i4,
                                                                                i5, i6, i7))
                                                                            continue;
                                                                    if (flags[7])
                                                                        for (int i8 = 0; i8 < array.length; i8++) {
                                                                            if (total_function(array, matrix_array,
                                                                                    matrix_diagonal_array, i1, i2, i3,
                                                                                    i4, i5, i6, i7, i8))
                                                                                continue;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        return total;
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static int[][] fun_reference_array(boolean flags[]) {
        int buffer_array[][];
        int reference_array[][] = {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 },
        };
        for (int i1 = 0; i1 < flags.length; i1++) {
            flags[i1] = true;
        }
        buffer_array = new int[8 + 1][8];
        for (int i1 = 0; i1 < buffer_array.length; i1++) {
            for (int i2 = 0; i2 < buffer_array[i1].length; i2++) {
                buffer_array[i1][i2] = reference_array[i1][i2];
            }
        }
        return buffer_array;
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean total_function(int array[][], int matrix_array[][], int matrix_diagonal_array[][],
            int... i_x) {
        int conuter = 0;
        for (int i1 : i_x) 
            matrix_array[conuter++] = array[i1];
        if (fun_compare_arrays_1(matrix_array, false))
            return true;// continue;// вертикальный поиск дубликатов единицы
        // ----------------------
        fun_initiation_array_1(matrix_diagonal_array, 0);// инициализируем массив
        fun_diagonal_initiation_array(matrix_array, matrix_diagonal_array, "с_права_на_лево");// с_права_на_лево
                                                                                              // с_лево_на_право
        if (false)
            show_array(matrix_diagonal_array);
        if (fun_compare_arrays_1(matrix_diagonal_array, true))
            return true; // continue;// если совпадение по диагноали, то продолжаем
        // ----------------------
        fun_initiation_array_1(matrix_diagonal_array, 0);// заново инициализируем массив
        fun_diagonal_initiation_array(matrix_array, matrix_diagonal_array, "с_лево_на_право");// с_права_на_лево
                                                                                              // с_лево_на_право
        if (false)
            show_array(matrix_diagonal_array);
        if (fun_compare_arrays_1(matrix_diagonal_array, true))
            return true;// continue;// если совпадение по диагноали, то продолжаем
        // ----------------------
        if (!fun_count_number_of_queens(matrix_diagonal_array))
            return true;// continue;//
        show_array(matrix_array);
        System.out.println("----------------------------");
        total++;
        return false;
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean fun_count_number_of_queens(int matrix_diagonal_array[][]) {                                                                                      
        int count = 0;
        for (int i1[] : matrix_diagonal_array) {
            for (int i2 : i1) {
                if (i2 == 1)
                    count++;
            }
        }
        if (count == 8)
            return true;
        return false;
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean fun_compare_arrays_1(int matrix_diagonal_array[][], boolean edges) {
        int count = 0;
        int edge;
        if (edges) {
            edge = 1;
        } else {
            edge = 0;
        }
        for (int i1 = edge; i1 < matrix_diagonal_array[0].length - edge; i1++) {// не трогаем края при поиске, так как
                                                                                // выпадение ед. равна одному разу
            count = 0;
            for (int i2 = 0; i2 < matrix_diagonal_array.length; i2++) {
                if (matrix_diagonal_array[i2][i1] == 1) {
                    count++;
                }
            }
            if (count >= 2)// если по диагонали встретились хотя бы две и более единицы
                return true;
        }
        return false;
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void fun_diagonal_initiation_array(int matrix_array[][], int matrix_diagonal_array[][], String LR) {
        boolean flag = false;
        int matrix_diagonal_array_length = matrix_diagonal_array[0].length;
        int matrix_array_length = matrix_array[0].length;
        int count = 0;
        for (int i1 = 0; i1 < matrix_diagonal_array.length; i1++) {
            if (LR.equals("с_права_на_лево")) {// с_лево_на_право
                int count_2 = 0;
                for (int i2 = matrix_diagonal_array_length - 1; matrix_array_length - 1 <= i2; i2--) {
                    matrix_diagonal_array[i1][i2 + count] = matrix_array[i1][i2 - matrix_array_length + 1];                    
                }
                count--;
            } else {
                for (int i2 = 0; i2 < matrix_array_length; i2++) {
                    matrix_diagonal_array[i1][i2 + count] = matrix_array[i1][i2];
                }
                count++;
            }
        }
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void fun_initiation_array_1(int array[][], int x1) {
        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i2 = 0; i2 < array[0].length; i2++) {
                array[i1][i2] = x1;
            }
        }
    }
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void show_array(int array[][]) {
        for (int i1[] : array) {
            for (int i2 : i1) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }
    }
}