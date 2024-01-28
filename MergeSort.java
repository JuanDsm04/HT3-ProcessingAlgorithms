/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de usar el algoritmo MergeSort
 * @references https://www.geeksforgeeks.org/merge-sort/
 */
public class MergeSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(T[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];
        for (int i = 0; i < n1; ++i) leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) rightArray[j] = arr[middle + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (((T) leftArray[i]).compareTo((T) rightArray[j]) <= 0) {
                arr[k] = (T) leftArray[i];
                i++;
            } else {
                arr[k] = (T) rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = (T) leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = (T) rightArray[j];
            j++;
            k++;
        }
    }
}