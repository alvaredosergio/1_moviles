package juego1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int palos = 21;
		int tachados = 0;
		int eleccion = 0;
		int maquina = 0;
		int contador1 = 0;
		int contador2 = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenido al juego de las cruces. Debes tachar de 1 a 4 palos en tu turno.");
		System.out.println("El que tache el último pierde. BUENA SUERTE!");
		pintar(palos, tachados);

		while (tachados < 21) {

			System.out.println("");

			System.out.println("Debes tachar de 1 a 4 palos. Cuantos deseas tachar?");
			eleccion = sc.nextInt();

			if (eleccion >= 1 && eleccion <= 4 && eleccion <= (palos - tachados)) {
				System.out.println("Has decidido tachar " + eleccion + " palos.");
				contador1++;

				tachados = tachados + eleccion;
				pintar(palos, tachados);

				if (tachados != 21) {

					maquina = 5 - eleccion;
					tachados = tachados + maquina;
					System.out.println("La máquina elige tachar " + maquina + " palos.");
					contador2++;
					pintar(palos, tachados);
				}

			} else {
				System.out.println("El número no es válido.");
			}

		}
		if (contador1 < contador2) {
			System.out.println("Enhorabuena, HAS GANADO!");
		} else {
			System.out.println("Lo siento, HAS PERDIDO!");
		}

	}

	public static void pintar(int palos, int tachados) {
		for (int j = 0; j < tachados; j++) {
			System.out.print("X ");
		}
		for (int i = 0; i < palos - tachados; i++) {
			System.out.print("/");
		}
		System.out.println("");
	}

}
