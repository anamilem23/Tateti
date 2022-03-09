package Proyecto_Tateti;

/* Ana Milena Arias Londoño 
 * Estudiante ADA
 */

import java.util.Scanner;

public class Tateti {
	private static int FILA = 3;
	private static int COLUMNA = 3;

	public static void main(String[] args) {
		char tablero[][] = new char[FILA][COLUMNA];
		int numJugada = 0; // contar las jugadas
		char indicador = 'O'; //
		int fila = 0, columna = 0;
		String jugadorX = ""; // llevar las jugadas de X
		String jugadorO = ""; // llevar las jugadas de O
		char postablero[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' }; // para usar en switch
		short posicionJugada = 0; // posicion escogida el juga
		boolean gano = false; // ¿hay ganador?

		try (Scanner sc = new Scanner(System.in)) {
			// crear tablero
			crearTablero(tablero, postablero);

			// mostrarTablero
			mostrarTablero(tablero);

			numJugada = 1;
			indicador = 'o';
			while (numJugada < 10) {

				System.out.println("Ingrese su jugada, posicion tablero? (de 1 a 9)	: ");
				posicionJugada = validarCasilla(1, 9);
				// con la posicion buscar la coordenada de la fila y columna para la jugada
				switch (posicionJugada) {
				case 1:
					fila = 0;
					columna = 0;
					break;
				case 2:
					fila = 0;
					columna = 1;
					break;
				case 3:
					fila = 0;
					columna = 2;
					break;
				case 4:
					fila = 1;
					columna = 0;
					break;
				case 5:
					fila = 1;
					columna = 1;
					break;
				case 6:
					fila = 1;
					columna = 2;
					break;
				case 7:
					fila = 2;
					columna = 0;
					break;
				case 8:
					fila = 2;
					columna = 1;
					break;
				case 9:
					fila = 2;
					columna = 2;
					break;
				} // switch

				if ((tablero[fila][columna]) == 'O' || (tablero[fila][columna]) == 'X') {

					System.out.println("La celda está ocupada juegue otra vez ");

				} else { // celda vacia tablero[fila][columna]

					if (indicador == 'X') {
						indicador = 'O';
						jugadorX = jugadorX + tablero[fila][columna]; // llevar las jugadas por X
					} else {
						indicador = 'X';
						jugadorO = jugadorO + tablero[fila][columna]; // llevar las jugadas por O
					}

					System.out.println("Jugadas de X son : " + jugadorX);
					System.out.println("Jugadas de O son : " + jugadorO);
					tablero[fila][columna] = indicador;
					numJugada++;

				} // if comprobar q contiene celda

				mostrarTablero(tablero);

				// diagonal principal posiciones 1, 5 y 9
				if (indicador == tablero[0][0] && indicador == tablero[1][1] && indicador == tablero[2][2]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 1, 5 y 9
					// diagonal principal posiciones 3, 5 y 7
				if (indicador == tablero[2][0] && indicador == tablero[1][1] && indicador == tablero[0][2]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 3, 5 y 7
					// diagonal principal posiciones 1, 2 y 3
				if (indicador == tablero[0][0] && indicador == tablero[0][1] && indicador == tablero[0][2]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 4, 5 y 6
					// diagonal principal posiciones 4, 5 y 6
				if (indicador == tablero[1][0] && indicador == tablero[1][1] && indicador == tablero[1][2]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 2, 5 y 8
					// diagonal principal posiciones 2, 5 y 8
				if (indicador == tablero[0][1] && indicador == tablero[1][1] && indicador == tablero[2][1]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 3, 6 y 9
					// diagonal principal posiciones 3, 6 y 9
				if (indicador == tablero[0][2] && indicador == tablero[1][2] && indicador == tablero[2][2]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}
				; // diagonal 1, 4 y 7
					// diagonal principal posiciones 1, 4 y 7
				if (indicador == tablero[0][0] && indicador == tablero[1][0] && indicador == tablero[2][0]) {
					System.out.println("Gano el jugador " + indicador);
					gano = true; // hay ganador
					numJugada = 10; // termina el juego
				}

			} // while
				// si no hay ganador
			if (gano == false) {
				System.out.println("En este juego no hubo ganador");
			}

		}

	} // main

	private static void crearTablero(char[][] tablero, char[] postablero) {
		int contar = 0;
		for (int c = 0; c < FILA; c++) {
			for (int d = 0; d < COLUMNA; d++) {
				tablero[c][d] = postablero[contar];
				contar++; // contar elementos de array posiciones de tablero
			} // for q recorre columnas
		} // for q recorre filas
	} // metodo crearTablero

	private static void mostrarTablero(char tablero[][]) {
		for (int c = 0; c < 3; c++) {
			for (int d = 0; d < 3; d++) {
				System.out.print((tablero[c][d]) + " | ");
			} // for recorre columnas
			System.out.println();
		} // for q recorre lineas
	} // metodo mostrar tablero

	private static short validarCasilla(int limMenor, int limMayor) {
		short numero = 99;
		Scanner sc = new Scanner(System.in);
		while (numero < limMenor || numero > limMayor) {
			System.out.println("Ingrese su coordena (de 1 a 9)	: ");
			numero = sc.nextShort();
		} // while

		return numero;

	} // valildar casilla

}// Ta_Te_Ti Ana Milena Arias Londoño
