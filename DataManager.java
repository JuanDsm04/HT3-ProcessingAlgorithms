/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de llevar el control de los datos en los archivos de texto
 */
import java.util.HashSet;
import java.util.Set;

public class DataManager {

    public int[] genRandomNumbers(int limit){
        int[] myNumbers = new int[limit];
        Set<Integer> savedNumbers = new HashSet<Integer>();
        for (int i = 0; i < limit; i++) {
            int randomNumber;
            do {
                randomNumber = (int)(Math.random()*15000) + 1;
            } while (savedNumbers.contains(randomNumber));
            myNumbers[i] = randomNumber;
            savedNumbers.add(randomNumber);
        }

        return myNumbers;
    }
    
    
}