package pipe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import org.junit.Test;
import sun.misc.IOUtils;

public class PipeToNum {

    private ArrayList listNum, listPipe, numeroDoPipe;
    PipeTo to = new PipeTo();
    ValidarPipe validar;
    private int a,l,c;
    private int aux,aux1,aux2,aux3;
    private String linha,num;
    
    public void contarLinha(String caminho) throws Exception { //OK
        LineNumberReader linha = null;
        System.out.println(caminho);
        linha = new LineNumberReader(new InputStreamReader(new FileInputStream(caminho)));
        String nextLine;
        this.aux=0;
        try {
            while ((nextLine = linha.readLine()) != null && aux == 0) {
                if (nextLine == null) {
                    aux = 1;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao Contar Linha !");
        }
        lerPipe(linha.getLineNumber(), caminho);
    }

    public void lerPipe(int num, String caminho) throws Exception { //OK
        to.setNumLinhas(num);
        to.criarMatriz(to.getNumLinhas(), 27);
        try {
            FileReader fileReader = new FileReader(caminho);
            BufferedReader reader = new BufferedReader(fileReader);
            this.l = 0;
            while (l < num) {
                this.c = 0;
                this.a = 0;
                this.linha = reader.readLine();
                while (c < 27) {
                    this.num = Character.toString(linha.charAt(a));
                    if (this.num.equals(" ")) {
                        to.setMatriz(l, c, 0);
                    }
                    if (this.num.equals("|")) {
                        to.setMatriz(l, c, 1);
                    }
                    if (this.num.equals("_")) {
                        to.setMatriz(l, c, 2);
                    }
                    this.a++;
                    this.c++;
                }
                this.l++;
            }
            fileReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro ao Ler o Pipe !");
        }
    }

    public void converterMatrizPipe() throws Exception { // OK
        try {
            int matriz[][] = to.getMatriz();
            this.listPipe = new ArrayList();
            this.aux1 = this.c = this.l = this.aux2 = this.aux3 = 0;
            //aux1 incrementa o loop para passar nas 3 primeiras colunas.
            //aux2 incrementa a linha 
            //aux3 incrementa a coluna
            //Em resumo estou lendo as 3 primeiras linhas e as 3 primeiras colunas.
            String numero;
            while (l < to.getNumLinhas()) {
                this.c=0;
                while (c < 27) {
                    this.aux3 = 0;
                    this.aux1 = 0;
                    numero = "";
                    while (this.aux1 < 3) {
                        numero = numero + matriz[l][c + this.aux3];
                        this.aux2++;
                        numero = numero + matriz[l + this.aux2][c + this.aux3];
                        this.aux2++;
                        numero = numero + matriz[l + this.aux2][c + this.aux3];
                        this.aux1++;
                        this.aux3++;
                        this.aux2 = 0;
                    }
                    this.listPipe.add(numero);
                    this.c += 3;
                }
                this.l += 3;
            }
        } catch (Exception e) {
            System.out.println("Erro ao Converter Matriz para Numero !");
        }
    }

    public void converterPipeToNum() throws Exception { // OK
        this.numeroDoPipe = new ArrayList();
        this.a = this.aux = this.aux2 = 0;
        this.aux3= listPipe.size();
        this.num = "";
        try {
            while (this.aux2 < this.aux3) {
                while (aux < 9) {
                    this.linha = (String) this.listPipe.get(a);
                    switch (this.linha) {
                        case "011202011":
                            this.num = this.num + 0;
                            this.a++;
                            break;
                        case "000000011":
                            this.num = this.num + 1;
                            this.a++;
                            break;
                        case "001222010":
                            this.num = this.num + 2;
                            this.a++;
                            break;
                        case "000222011":
                            this.num = this.num + 3;
                            this.a++;
                            break;
                        case "010020011":
                            this.num = this.num + 4;
                            this.a++;
                            break;
                        case "010222001":
                            this.num = this.num + 5;
                            this.a++;
                            break;
                        case "011222001":
                            this.num = this.num + 6;
                            this.a++;
                            break;
                        case "000200011":
                            this.num = this.num + 7;
                            this.a++;
                            break;
                        case "011222011":
                            this.num = this.num + 8;
                            this.a++;
                            break;
                        case "010222011":
                            this.num = this.num + 9;
                            this.a++;
                            break;
                        default:
                            this.num = this.num + "?";
                            this.a++;
                            break;
                            
                    }
                    this.aux++;
                    this.aux2++;
                }
                this.numeroDoPipe.add((String)(this.num));
                this.num = "";
                this.aux = 0;
            }
        } catch (Exception e) {
            System.out.println("Erro ao Converter para numero final");
        }
        validarPipe();
    }

    public ArrayList getNumero() {
        return this.numeroDoPipe;
    }
    
    public int [][] getMatriz(){
        return this.to.getMatriz();
    }
    
    public int getNumLinhas(){
        return this.to.getNumLinhas();
    }
    
    public void validarPipe(){
        this.validar=new ValidarPipe();
        this.numeroDoPipe=this.validar.validarNum(this.numeroDoPipe);
    }
}
