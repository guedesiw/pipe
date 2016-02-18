package pipe;

import java.util.ArrayList;

public class ValidarPipe {

    private ArrayList lista;
    private int size = 0;
    private int i = 0;
    private int soma;
    private int size2;
    private int numero;
    private int mod = 0;
    private int tempVar;
    private int var;
    private String aux;
    private String temp;
        
    public ArrayList validarNum(ArrayList list) {
        this.lista = list;
        while (this.size < list.size()) {
            this.aux = (String) list.get(i);
            this.tempVar = 0;
            this.size2 = 0;
            this.var = 9;
            this.soma = 0;
            while (this.size2 < aux.length() && this.tempVar == 0) {
                this.temp = Character.toString(this.aux.charAt(this.size2));
                if (this.temp.equals("?")) {
                    this.lista.set(i, list.get(i) + "  ILL");
                    this.tempVar++;
                }
                if (this.tempVar == 0) {
                    this.numero = Integer.parseInt(Character.toString(this.aux.charAt(this.size2)));
                    this.soma += this.numero * this.var;
                    this.var--;
                }
                this.size2++;

            }
            if (this.tempVar == 0) {
                this.mod = this.soma % 11;
            }
            if (this.mod != 0 && this.tempVar == 0) {
                this.lista.set(i, list.get(i) + "  ERR");
            }
            this.i++;
            this.size++;
        }
        return this.lista;
    }
}
