/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de usar el algoritmo GnomeSort
 * @references https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
 */
public class GnomeSort<T extends Comparable<T>> implements ISort<T>{

    @Override
    public T[] sort(T[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            }
            if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return arr;
    }
}