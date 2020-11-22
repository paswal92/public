import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char[][] spielfeld = new char[3][3];

	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);
		System.out.println("Let's Play Tic Tac Toe");
		init();
		printSpielfeld();
		boolean spielerX = true;
		int counter = 0;
		int position = 0;

		while (counter < 9) {
			if (!spielerX) {
				System.out.print("SpielerIn X: ");
				position = keyScan.nextInt();
				counter++;
				spielerX = true;
			} else {
				System.out.print("SpielerIn O: ");
				position = keyScan.nextInt();
				counter++;
				spielerX = false;
			}

			// Wert besezt
			if (spielfeld[getSpalte(position)][getZeile(position)] == 'X'
					|| spielfeld[getSpalte(position)][getZeile(position)] == 'O') {
				counter--;
				spielerX = !spielerX;
				System.out.println("Dieses Feld ist schon besetzt, bitte wiederhole deine Eingabe!");
				printSpielfeld();
				continue;

			}

			// Wert auserhalb
			if (0 >= position || position >= 10) {
				counter--;
				spielerX = !spielerX;
				System.out.println(
						"Das geht so nicht! Dein Wert muss zwischen 1-9 liegen, bitte wiederhole deine Eingabe!");
				printSpielfeld();
				continue;
			} else {
				speichere(position, spielerX);
				printSpielfeld();
			}

			// Gewinner ausgeben
			if (hatGewonnen(spielerX)) {
				System.out.print("Spieler X hat gewonnen!");
				break;
			}
			if (hatGewonnen(!spielerX)) {
				System.out.print("Spieler O hat gewonnen!");
				continue;
			}

		}
		if (counter == 9) {
			System.out.print("Unentschieden!");
		}

		keyScan.close();
	}

	static void init() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				spielfeld[i][j] = '.';
			}
		}

	}

	static void speichere(int position, boolean spielerX) {
		spielfeld[getSpalte(position)][getZeile(position)] = getSymbol(spielerX);
	}

	static int getZeile(int position) {
		if (position == 1 || position == 4 || position == 7) {
			return 0;
		} else if (position == 2 || position == 5 || position == 8) {
			return 1;
		}

		return 2;
	}

	static int getSpalte(int position) {

		if (position <= 3) {
			return 0;
		} else if (position <= 6 && position >= 4) {
			return 1;
		}
		return 2;
	}

	static char getSymbol(boolean spielerX) {
		if (!spielerX) {
			return 'O';
		}
		return 'X';
	}

	static void printSpielfeld() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + spielfeld[i][j]);
			}
			System.out.println("");
		}
	}

	static boolean hatGewonnen(boolean spielerX) {
		spielerX = false;
		for (int i = 0; i < 3; i++) {
			if (spielfeld[i][0] == spielfeld[i][1] && spielfeld[i][1] == spielfeld[i][2] && spielfeld[i][0] != '.') {
				spielerX = true;
				return spielerX;
			}
		}
		spielerX = false;
		for (int j = 0; j < 3; j++) {
			if (spielfeld[0][j] == spielfeld[1][j] && spielfeld[1][j] == spielfeld[2][j] && spielfeld[0][j] != '.') {
				spielerX = true;
				return spielerX;
			}
		}
		spielerX = false;
		if (spielfeld[0][0] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[2][2] && spielfeld[0][0] != '.') {
			spielerX = true;
			return spielerX;
		}
		spielerX = false;
		if (spielfeld[2][0] == spielfeld[1][1] && spielfeld[1][1] == spielfeld[0][2] && spielfeld[2][0] != '.') {
			spielerX = true;
			return spielerX;
		}
		return spielerX;
	}

}
