/**
 * @author Diego Flores & Juan Solis
 * @creationDate 24/01/2024
 * @description Clase encargada de llevar el control de los datos en los archivos de texto
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class DataManager {

    private File file;

    public DataManager(String fileName){
        file = new File(fileName);
    }

    public Integer[] genRandomNumbers(int limit) {
        Integer[] myNumbers = new Integer[limit];
        Set<Integer> savedNumbers = new HashSet<>();
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

    public void write(Integer[] numbers) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter(file, false));
        for (Integer number : numbers) {
            writer.println(number);
        }
        writer.close();
    }

    public Integer[] read(int limit) throws Exception {
        if (file.exists()) {
            Integer[] selectedNumbers = new Integer[limit];
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line = buffer.readLine();
            for (int i = 0; i < selectedNumbers.length && line != null; i++) {
                selectedNumbers[i] = Integer.parseInt(line);
                line = buffer.readLine();
            }
            buffer.close();
            return selectedNumbers;
        } else {
            return null;
        }
    }
}