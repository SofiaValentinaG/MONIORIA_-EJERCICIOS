package Ejercicio2;
import java.util.Random;

public class BatallaNaval{

  //metodo que recibe la matriz de 9x9
    public static void inicializar(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) { //recorre las filas
            for (int j = 0; j < matriz[i].length; j++) { //recorre las columnas
                matriz[i][j] = "~";
            }
        }
    }


    public static void colocarBarcos(String[][] matriz) {
        Random random = new Random();
        int barcos = 3; 

        while (barcos > 0) {
            int fila = random.nextInt(9);
            int columna = random.nextInt(9);
            int orientacion = random.nextInt(2); 
            int tamaño = barcos; 

            boolean sePuedeColocar = true;

           
            if (orientacion == 0) { 
                if (columna + tamaño > 9) sePuedeColocar = false; 
                else {
                    for (int j = 0; j < tamaño; j++) {
                        if (matriz[fila][columna + j].equals("*")) {
                            sePuedeColocar = false;
                            break;
                        }
                    }
                }
            } else { 
                if (fila + tamaño > 9) sePuedeColocar = false;
                else {
                    for (int i = 0; i < tamaño; i++) {
                        if (matriz[fila + i][columna].equals("*")) { //desplazamiento del barco de manera vertical
                            sePuedeColocar = false;
                            break;
                        }
                    }
                }
            }

         
            if (sePuedeColocar) {
                if (orientacion == 0) {
                    for (int j = 0; j < tamaño; j++) {
                        matriz[fila][columna + j] = "*"; //desplazamiento del barco de manera horizonal
                    }
                } else {
                    for (int i = 0; i < tamaño; i++) {
                        matriz[fila + i][columna] = "*"; // desplazamiento del barco de manera vertical
                    }
                }
                barcos--; 
            }
        }
    }


    public static void mostrar(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] matriz1 = new String[9][9];
        String[][] matriz2 = new String[9][9];

        inicializar(matriz1);
        inicializar(matriz2);

        colocarBarcos(matriz1);
        colocarBarcos(matriz2);

        System.out.println("Tablero 1:");
        mostrar(matriz1);

        System.out.println("\nTablero 2:");
        mostrar(matriz2);
    }
}
