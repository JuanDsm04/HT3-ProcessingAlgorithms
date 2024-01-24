/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Interfaz encargada de modelar el metodo sort genérico
 */
public interface ISort<T extends Comparable<T>> {
    public T[] sort(T[] arr);
}