/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de ejecutar el programa
 */
public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager("numeros.txt");
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        RadixSort<Integer> radixSort = new RadixSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        try {
            Integer[] randomNumbers = dataManager.genRandomNumbers(15000);
            dataManager.write(randomNumbers);

            int limit = 10;
            while (limit <= 3010) {
                Integer[] dataCopy = dataManager.read(limit).clone();
                gnomeSort.sort(dataCopy);
            
                Integer[] dataCopyMerge = dataManager.read(limit).clone();
                mergeSort.sort(dataCopyMerge);

                Integer[] dataCopyQuick = dataManager.read(limit).clone();
                quickSort.sort(dataCopyQuick);
               
                Integer[] dataCopyRadix = dataManager.read(limit).clone();
                radixSort.sort(dataCopyRadix);

                Integer[] dataCopyInsertion = dataManager.read(limit).clone();
                insertionSort.sort(dataCopyInsertion);
                
                limit += 200;
            }

        } catch (Exception e) {
            System.err.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
}