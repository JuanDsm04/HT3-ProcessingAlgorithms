import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        try {
            Integer[] randomNumbers = dataManager.genRandomNumbers(15000);
            dataManager.write(randomNumbers);

            System.out.println("\nORDENAMIENTO CON ALGORITMOS: ");
            System.out.print("Ingrese el número de elementos a ordenar: ");
            String limit = sc.nextLine();
            System.out.println("\nEl arreglo sera:");
            System.out.println("1. Desordenado");
            System.out.println("2. Ordenado");
            System.out.print("Elige la opción que desees: ");
            String op = sc.nextLine();
            try {
                int limitNumber, opcion;
                switch (op) {
                    case "1":
                        limitNumber = Integer.parseInt(limit);
                        System.out.println("1. Gnome Sort");
                        System.out.println("2. Merge Sort");
                        System.out.println("3. Quick Sort");
                        System.out.println("4. Radix Sort");
                        System.out.println("5. Insertion Sort");
                        System.out.print("Selecciona el algoritmo de ordenamiento:");
                        opcion = sc.nextInt();
        
                        switch (opcion) {
                            case 1:
                                Integer[] dataCopy = dataManager.read(limitNumber).clone();
                                gnomeSort.sort(dataCopy);
                                System.out.println("Lista ordenada con GnomeSort");
                                break;
                            
                            case 2:
                                Integer[] dataCopyMerge = dataManager.read(limitNumber).clone();
                                mergeSort.sort(dataCopyMerge);
                                System.out.println("Lista ordenada con MergeSort");
                                break;
        
                            case 3:
                                Integer[] dataCopyQuick = dataManager.read(limitNumber).clone();
                                quickSort.sort(dataCopyQuick);
                                System.out.println("Lista ordenada con QuickSort");
                                break;
        
                            case 4:
                                Integer[] dataCopyRadix = dataManager.read(limitNumber).clone();
                                radixSort.sort(dataCopyRadix);
                                System.out.println("Lista ordenada con RadixSort");
                                break;
        
                            case 5:
                                Integer[] dataCopyInsertion = dataManager.read(limitNumber).clone();
                                insertionSort.sort(dataCopyInsertion);
                                System.out.println("Lista ordenada con InsertionSort");
                                break;
                            
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                        break;
                    case "2":
                        limitNumber = Integer.parseInt(limit);
                        System.out.println("1. Gnome Sort");
                        System.out.println("2. Merge Sort");
                        System.out.println("3. Quick Sort");
                        System.out.println("4. Radix Sort");
                        System.out.println("5. Insertion Sort");
                        System.out.print("Selecciona el algoritmo de ordenamiento:");
                        opcion = sc.nextInt();
        
                        switch (opcion) {
                            case 1:
                                Integer[] dataCopy = dataManager.read(limitNumber).clone();
                                Integer[] sortedGnome = quickSort.sort(dataCopy);
                                gnomeSort.sort(sortedGnome);
                                System.out.println("Lista ordenada con GnomeSort");
                                break;
        
                            case 2:
                                Integer[] dataCopyMerge = dataManager.read(limitNumber).clone();
                                Integer[] sortedMerge = quickSort.sort(dataCopyMerge);
                                mergeSort.sort(sortedMerge);
                                System.out.println("Lista ordenada con MergeSort");
                                break;
        
                            case 3:
                                Integer[] dataCopyQuick = dataManager.read(limitNumber).clone();
                                Integer[] sortedQuick = radixSort.sort(dataCopyQuick);
                                quickSort.sort(sortedQuick);
                                System.out.println("Lista ordenada con QuickSort");
                                break;
        
                            case 4:
                                Integer[] dataCopyRadix = dataManager.read(limitNumber).clone();
                                Integer[] sortedRadix = quickSort.sort(dataCopyRadix);
                                radixSort.sort(sortedRadix);
                                System.out.println("Lista ordenada con RadixSort");
                                break;
        
                            case 5:
                                Integer[] dataCopyInsertion = dataManager.read(limitNumber).clone();
                                Integer[] sortedInsertion = quickSort.sort(dataCopyInsertion);
                                insertionSort.sort(sortedInsertion);
                                System.out.println("Lista ordenada con InsertionSort");
                                break;
        
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                        break;
                
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                System.out.println("");
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es un número");
                return;
            }


        } catch (Exception e) {
            System.err.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
}