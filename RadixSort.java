import java.util.Arrays;

/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de usar el algoritmo RedixSort
 */
public class RadixSort <T extends Comparable<T>> implements ISort<T>{

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
        return arr;
    }

    private int getMax(T[] arr) {
        int max = (int) arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((int) arr[i] > max) {
                max = (int) arr[i];
            }
        }
        return max;
    }

    private void countingSort(T[] arr, int exp) {
        int n = arr.length;
        T[] output = Arrays.copyOf(arr, n);
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[((int) arr[i]) / exp % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[((int) arr[i]) / exp % 10] - 1] = arr[i];
            count[((int) arr[i]) / exp % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}