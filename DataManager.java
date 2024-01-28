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

    public void write(int[] numbers)throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter(file, false));
        for (int i=0; i<numbers.length; i++){
            writer.println(numbers[i]);
        }
        writer.close();
    }

    public int[] read(int limit) throws Exception{
        if (file.exists()) {
            int[] selectedNumbers = new int[limit];
            BufferedReader bufer = new BufferedReader(new FileReader(file));
            String line = bufer.readLine();
            for (int i = 0; i < selectedNumbers.length; i++) {
                if(line != null){
                    selectedNumbers[i] = Integer.parseInt(line);
                    line = bufer.readLine();
                }
            }
            if(line !=null){
                bufer.close();
            }
            return selectedNumbers;
        }else{
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            String line = "ID,Nombre,CantDisponible,CantVendida,Estado,Precio,Mililitros,TipoBebida,Gramos,Sabor,Tamanio,TipoCarne,Origen,TipoProducto\n";
            writer.print(line);
            writer.close();
            return null;
        }
    }
    
    
}