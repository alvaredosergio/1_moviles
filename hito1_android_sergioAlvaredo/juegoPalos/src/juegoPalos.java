import java.util.Scanner;

public class juegoPalos {
		public static void main(String[] args) {
		int sticks = 21;
		int crossed = 0;
		int decision = 0;
		int machine = 0;
		int c1 = 0;
		int c2 = 0;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("\033[H\033[2JBienvenido al juego de los Palos Tachados. Debes tachar de 1 a 4 palos en tu turno.");
		System.out.println("El que tache en último lugar, pierde. BUENA SUERTE!!\n");
		pintar(sticks, crossed);

		while (crossed < 21) {
			System.out.println("\nDebes tachar de 1 a 4 palos. ¿Cuantos palos deseas tachar?");
			decision = sc.nextInt();
			
			if (decision >= 1 && decision <= 4 && decision <= (sticks-crossed)) {
				System.out.println("Has decidido tachar " + decision + " palo/s.");
				c1++;
				crossed += decision;
				pintar(sticks, crossed);
				System.out.println();

				if (crossed != 21) {
					machine = 5 - decision;
					crossed += machine;
					System.out.println("La máquina elige tachar " + machine + " palos.");
					c2++;
					pintar(sticks, crossed);
				}

			} else {
				System.out.println("El número no es válido. Introduzcalo de nuevo.");
			}
		}
		if (c1 < c2) {
			System.out.println("\nEnhorabuena, HAS GANADO!!");
		} else {
			System.out.println("Eres el último en tachar el último palo. Lo siento, HAS PERDIDO!!");
			System.out.println("\r"
			+ "  _____                   ____                 \r\n"
			+ " / ___/___ _ __ _  ___   / __ \\ _  __ ___  ____\r\n"
			+ "/ (_ // _ `//  ' \\/ -_) / /_/ /| |/ // -_)/ __/\r\n"
			+ "\\___/ \\_,_//_/_/_/\\__/  \\____/ |___/ \\__//_/   \r\n"
			+ "                                               \r"
			+ "");
		}
		sc.close();
	}

	public static void pintar(int sticks, int crossed) {
		String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
		for (int j = 0; j < crossed; j++) {
			System.out.print(green + "X");
			System.out.print(reset);
		}
		for (int i = 0; i < sticks - crossed; i++) {
			System.out.print(red + "/");
			System.out.print(reset);
		}
		System.out.println("");
	}
}
