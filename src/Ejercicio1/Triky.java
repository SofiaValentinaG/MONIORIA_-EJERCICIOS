package Ejercicio1;

import java.util.Scanner;

public class Triky {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] tablero = new char[3][3];
		char jugador = 'X';
		boolean juegoTerminado = false;

// se inicaliza el tablero
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[i][j] = ' ';
			}
		}

		while (!juegoTerminado) {
			imprimirTablero(tablero);
			System.out.println("Turno de " + jugador + ". Ingresa fila (0-2) y columna (0-2): ");
			int fila = sc.nextInt();
			int columna = sc.nextInt();

			if (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ') {
				System.out.println("intenta de nuevo.");

			} else {

				tablero[fila][columna] = jugador;

				
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
		sc.close();
	}

	static void imprimirTablero(char[][] t) {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(t[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static boolean hayGanador(char[][] t, char j) {
		// Filas
		for (int i = 0; i < 3; i++) {
			if (t[i][0] == j && t[i][1] == j && t[i][2] == j)
				return true;
		}
		// Columnas
		for (int jCol = 0; jCol < 3; jCol++) {
			if (t[0][jCol] == j && t[1][jCol] == j && t[2][jCol] == j)
				return true;
		}
		// Diagonales
		if (t[0][0] == j && t[1][1] == j && t[2][2] == j)
			return true;
		if (t[0][2] == j && t[1][1] == j && t[2][0] == j)
			return true;

		return false;
	}

	static boolean tableroLleno(char[][] t) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (t[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
}
