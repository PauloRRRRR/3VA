package Q3;

import java.util.Random;


class Control {

    private final static int colunas = 20;
    private final static int linhas = 10;
    private static volatile int[][] matriz = new int[linhas][colunas];
    private static Random geraNum = new Random();
    private static SomaMatriz m1, m2, m3, m4;

    public static void main(String[] args) throws InterruptedException{

        for(int j = 0; j < linhas; j++){
            for(int i = 0; i < colunas; i++){
                matriz[j][i] = geraNum.nextInt(100);
            }
        }
        //instancias da minha classe somamatriz que recebem como argumento a matriz e o thread
        m1 = new SomaMatriz(matriz, 0);
        m2 = new SomaMatriz(matriz, 1);
        m3 = new SomaMatriz(matriz, 2);
        m4 = new SomaMatriz(matriz, 3);
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        Thread t4 = new Thread(m4);

        //threads entram em execução
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        int Sum = somaThread();

        System.out.println("Soma total: " + Sum);
    }

    //Soma total
    private static int somaThread(){
        return m1.getSomaTotal() + m2.getSomaTotal() + m3.getSomaTotal() + m4.getSomaTotal();
    }

}
