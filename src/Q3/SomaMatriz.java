package Q3;

public class SomaMatriz implements Runnable{

    private int[][] matriz;
    private int threadId;
    private int somaTotal;

    public SomaMatriz(int[][] arr, int threadId){
        this.matriz = arr;
        this.threadId = threadId;
        this.setSomaTotal(0);
    }


    @Override
    public void run() {
        int matrizColuna = matriz[0].length;
        int matrizLinha = matriz.length;
        int geraColuna = (int)((threadId %2) * (matrizColuna/2));
        int geraLinha = (int)((int)(threadId /2) * (matrizLinha/2));
        int finalColuna = geraColuna + (int)(matrizColuna/2);
        int finalLinha = geraLinha + (int)(matrizLinha/2);

            for(int j = geraLinha; j < finalLinha; j++){
                setSomaTotal(getSomaTotal() + matriz[j][geraColuna]);
            }

    }

    public int getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(int somaTotal) {
        this.somaTotal = somaTotal;
    }

}