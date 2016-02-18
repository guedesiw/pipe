package pipe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class NovoClass {

    /*
    public static void main(String[] args) {
        PipeToNum var = new PipeToNum();
        boolean result = var.validarNum(435346333);
        System.out.println(result);
    }
     */
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        LineNumberReader linha = new LineNumberReader(new InputStreamReader(new FileInputStream("C:\\Users\\PC-VELHO\\Desktop\\txt.txt")));
        String nextLine;
        int aux = 0; // Verifica se a proxima linha está vazia.
        try {
            while ((nextLine = linha.readLine()) != null) {
                if (nextLine == null) {
                    break;
                }
                /*
                if (nextLine == null) {
                    if (aux <= 3) {
                        aux++;
                    } else {
                        break;
                    }
                } else {
                    aux = 0;
                }
*/
            }
        } catch (Exception e) {
            System.out.println("Nao deu certo !");
        }
        System.out.println(linha.getLineNumber());
    }
}
