/**
 * @author Diego Flores & Juan Solis
 * @creationDate 27/01/2024
 * @description Clase encargada de usar el algoritmo InsertionSort
 * @references https://www.javapoint.com/insertion-sort-in-java
 */
public class InsertionSort<T extends Comparable<T>> implements ISort<T>{
    @Override
    public T[] sort(T[] array) {
        int n = array.length;

        for (int j = 1; j < n; j++) {
            T key = array[j];
            int i = j - 1;

            while (i > -1 && array[i].compareTo(key) > 0) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }

        return array;
    }
}