package pipe;

public class PipeTo {

    private String caminhoArquivo;
    private int numLinhas;
    private int matriz[][];

    public void criarMatriz(int l,int c){
        this.matriz=new int[l][c];
    }
    
    public void setMatriz(int l,int c, int valor){
        this.matriz[l][c]=valor;
    }
    
    public int[][] getMatriz(){
        return this.matriz;
    }
    
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public int getNumLinhas() {
        return numLinhas;
    }

    public void setNumLinhas(int num) {
        this.numLinhas = num;
    }
}
