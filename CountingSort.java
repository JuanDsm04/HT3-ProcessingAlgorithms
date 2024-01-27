/**
 * @author: Diego Flores & Juan Solis
 * @creationDate: 26/01/2024
 * @description: Clase encargada de usar el algoritmo CountingSort 
 * @references: https://www.geeksforgeeks.org/counting-sort/
 */

import java.util.Arrays;

public class CountingSort<T extends Comparable<T>> implements ISort<T>{
    @Override
    public T[] sort(T[] inputArray){
        int N = inputArray.length;
        T max = inputArray[0];

        for (int i = 1; i < N; i++){
            if (inputArray[i].compareTo(max) > 0){
                max = inputArray[i];
            }
        }

        int[] countArray = new int[((Integer) max) + 1];
        for (int i = 0; i < N; i++) {
            countArray[(Integer) inputArray[i]]++;
        }
        for (int i = 1; i <= ((Integer) max); i++){
            countArray[i] += countArray[i - 1];
        }

        T[] outputArray = Arrays.copyOf(inputArray, N);
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[(Integer) inputArray[i]] - 1] = inputArray[i];
            countArray[(Integer) inputArray[i]]--;
        }

        return outputArray;
    }
}