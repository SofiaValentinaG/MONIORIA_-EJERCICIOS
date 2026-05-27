package Ejercicio3;

import java.util.Scanner;

public class Conecta4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		char[][] tablero = new char[4][4];
		char jugador = 'X';
		boolean juegoTerminado = false;

// se inicaliza el tablero
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tablero[i][j] = ' ';
			}
		}

		while (!juegoTerminado) {
			imprimirTablero(tablero);
			System.out.println("Turno de " + jugador + ". la  columna (0-3): ");
		
			int columna = sc.nextInt();
			System.out.println(columna);


			if ( columna < 0 || columna > 3|| (tablero[0][columna] != ' ' &&tablero[1][columna] != ' '&& tablero[2][columna] != ' ' &&tablero[3][columna] != ' ')) {
				System.out.println("intenta de nuevo.");

			} else {
				boolean jugo= false;
				
				for(int i=0; i < 4; i++){
				
				int bajar= 3-i;
				
				
					if(tablero[bajar][columna] == ' ') {
						tablero[bajar][columna] = jugador;
						jugo=true;
						break;
						
					}
				}
				if(jugo==true) {
					if (hayGanador(tablero, jugador)) {
						imprimirTablero(tablero);
						System.out.println("¡" + jugador + " gana!");
						juegoTerminado = true;
					} else if (tableroLleno(tablero)) {
						imprimirTablero(tablero);
						System.out.println("Empate.");
						juegoTerminado = true;
					} else {
						jugador = (jugador == 'X') ? 'O' : 'X';
					}
				
				}
			}
		}
		sc.close();
	}

	static void imprimirTablero(char[][] t) {
		System.out.println("-------------");
		for (int i = 0; i < 4; i++) {
			System.out.print("| ");
			for (int j = 0; j < 4; j++) {
				System.out.print(t[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static boolean hayGanador(char[][] t, char j) {
		// Filas
		for (int i = 0; i < 4; i++) {
			if (t[i][0] == j && t[i][1] == j && t[i][2] == j && t[i][3] == j)
				return true;
		}
		// Columnas
		for (int jCol = 0; jCol < 3; jCol++) {
			if (t[0][jCol] == j && t[1][jCol] == j && t[2][jCol] == j && t[3][jCol] == j)
				return true;
		}
		// Diagonales
		if (t[0][0] == j && t[1][1] == j && t[2][2] == j && t[3][3] == j)
			return true;
		if (t[0][3] == j && t[1][2] == j && t[2][1] == j && t[3][0] == j)
			return true;

		return false;
	}

	static boolean tableroLleno(char[][] t) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (t[i][j] == ' ')
					return false;
			}
		}
		return true;
	}

}
