import java.util.Arrays;

// Задача 1. Реализовать алгоритм сортировки слиянием.
public class Zadacha_1 {

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1)
            return buffer1;        

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = new int[buffer2.length];
        if (sorted1 == buffer1) 
            result = buffer2;
        else
            result = buffer1;

        while (index1 < middle && index2 < endIndex) {
            if (sorted1[index1] < sorted2[index2])
                result[destIndex++] = sorted1[index1++];                

            else
                result[destIndex++] = sorted2[index2++];

        }

        while (index1 < middle) 
            result[destIndex++] = sorted1[index1++];        
        while (index2 < endIndex) 
            result[destIndex++] = sorted2[index2++];        
        return result;
    }

    public static void main(String args[]) {
        int[] sortArr = {61, 22, 2, 5, 71, 66};
        int[] result = mergeSort(sortArr);        

        System.out.println(Arrays.toString(result));
    }
}