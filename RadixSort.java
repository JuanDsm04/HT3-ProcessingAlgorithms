/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de usar el algoritmo RedixSort
 * @references https://www.geeksforgeeks.org/radix-sort/
 */
import java.util.Arrays;

public class RadixSort <T extends Comparable<T>> implements ISort<T>{

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        Integer max = getMax(arr);
        for (Integer exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
        return arr;
    }

    private Integer getMax(T[] arr) {
        Integer max = (Integer) arr[0];
        for (Integer i = 1; i < arr.length; i++) {
            if ((Integer) arr[i] > max) {
                max = (Integer) arr[i];
            }
        }
        return max;
    }

    private void countingSort(T[] arr, Integer exp) {
        Integer n = arr.length;
        T[] output = Arrays.copyOf(arr, n);
        Integer[] count = new Integer[10];
        Arrays.fill(count, 0);
        for (Integer i = 0; i < n; i++) {
            count[((Integer) arr[i]) / exp % 10]++;
        }
        for (Integer i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (Integer i = n - 1; i >= 0; i--) {
            output[count[((Integer) arr[i]) / exp % 10] - 1] = arr[i];
            count[((Integer) arr[i]) / exp % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}