package Ejercicio2;
import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {

    public static void inicializar(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
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

            if (orientacion == 0) { // horizontal
                if (columna + tamaño > 9) sePuedeColocar = false;
                else {
                    for (int j = 0; j < tamaño; j++) {
                        if (matriz[fila][columna + j].equals("*")) {
                            sePuedeColocar = false;
                            break;
                        }
                    }
                }
            } else { // vertical
                if (fila + tamaño > 9) sePuedeColocar = false;
                else {
                    for (int i = 0; i < tamaño; i++) {
                        if (matriz[fila + i][columna].equals("*")) {
                            sePuedeColocar = false;
                            break;
                        }
                    }
                }
            }

            if (sePuedeColocar) {
                if (orientacion == 0) {
                    for (int j = 0; j < tamaño; j++) {
                        matriz[fila][columna + j] = "*";
                    }
                } else {
                    for (int i = 0; i < tamaño; i++) {
                        matriz[fila + i][columna] = "*";
                    }
                }
                barcos--;
            }
        }
    }

    public static void mostrarJugador(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("*")) {
                    System.out.print("~ "); 
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int jugarTurno(String[][] tablero, Scanner sc) {
        mostrarJugador(tablero);
        System.out.print("Ingresa fila (0-8): ");
        int fila = sc.nextInt();
        System.out.print("Ingresa columna (0-8): ");
        int columna = sc.nextInt();

        if (tablero[fila][columna].equals("*")) {
            System.out.println("encontraste un barco");
            tablero[fila][columna] = "X";
            return 1; 
        } else {
            System.out.println(" agua");
            tablero[fila][columna] = "o";
            return 0;
        }
    }

    public static void main(String[] args) {
        String[][] matriz1 = new String[9][9]; 
        String[][] matriz2 = new String[9][9];


        inicializar(matriz1);
        inicializar(matriz2);

        colocarBarcos(matriz1);
        colocarBarcos(matriz2);

        Scanner sc = new Scanner(System.in);
        int barcos1 = 6; 
        int barcos2 = 6; 

   

        while (barcos1 > 0 && barcos2 > 0) {
            System.out.println("turno Jugador 1:");
            barcos2 -= jugarTurno(matriz2, sc);

            if (barcos2 == 0) {
                System.out.println("Jugador 1 ha ganado, hundió todos los barcos del Jugador 2");
                break;
            }

            System.out.println("Turno Jugador 2:");
            barcos1 -= jugarTurno(matriz1, sc);

            if (barcos1 == 0) {
                System.out.println(" Jugador 2 ha ganado, hundió todos los barcos del Jugador 1");
                break;
            }
        }
    }
}


	