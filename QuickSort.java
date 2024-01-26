/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de usar el algoritmo QuickSort
 */
public class QuickSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(T[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
    
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high){
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j].compareTo(pivot) <= 0){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}