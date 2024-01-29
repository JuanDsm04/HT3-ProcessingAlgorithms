/**
 * @author Diego Flores & Juan Solis
 * @creationDate 28/01/2024
 * @description Clase encargada de testear los diferentes algoritmos de ordenación
 */

import org.junit.*;

public class SortTest {
    /**
     * Test que comprueba que el algoritmo MergeSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para no fallar)
     */
    @Test
    public void MergeSortTest(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        Integer[] expected = {1,2,3,4,5,6,7,8,9};
        MergeSort<Integer> ms = new MergeSort<Integer>();
        Assert.assertArrayEquals(expected, ms.sort(actual));
    }

    /**
     * Test que comprueba que el algoritmo RadixSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para no fallar)
     */
    @Test
    public void RadixSortTest(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        Integer[] expected = {1,2,3,4,5,6,7,8,9};
        RadixSort<Integer> rs = new RadixSort<Integer>();
        Assert.assertArrayEquals(expected, rs.sort(actual));
    }

    /**
     * Test que comprueba que el algoritmo QuickSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para no fallar)
     */
    @Test
    public void QuickSortTest(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        Integer[] expected = {1,2,3,4,5,6,7,8,9};
        QuickSort<Integer> qs = new QuickSort<Integer>();
        Assert.assertArrayEquals(expected, qs.sort(actual));
    }

    /**
     * Test que comprueba que el algoritmo GnomeSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para no fallar)
     */
    @Test
    public void GnomeSortTest(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        Integer[] expected = {1,2,3,4,5,6,7,8,9};
        GnomeSort<Integer> gs = new GnomeSort<Integer>();
        Assert.assertArrayEquals(expected, gs.sort(actual));
    }

    /**
     * Test que comprueba que el algoritmo InsertionSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para no fallar)
     */
    @Test
    public void InsertionSortTest(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        Integer[] expected = {1,2,3,4,5,6,7,8,9};
        InsertionSort<Integer> is = new InsertionSort<Integer>();
        Assert.assertArrayEquals(expected, is.sort(actual));
    }

    /**
     * Test que comprueba que el algoritmo InsertionnSort sea capaz de ordenar un arreglo de numeros enteros
     * (Prueba hecha para fallar)
     * Lo comparará con el mismo arreglo antes de ser ordenado
     */
    @Test
    public void InsertionSortTestFail(){
        Integer[] actual = {9,6,8,5,7,4,3,2,1};
        InsertionSort<Integer> is = new InsertionSort<Integer>();
        Assert.assertArrayEquals(actual.clone(), is.sort(actual));
    }
}