import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char [][] spielfeld = new char[3][3];

	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);
		System.out.println("Let's Play Tic Tac Toe");
		init();
		printSpielfeld();
		boolean spielerX  = true;
		int counter = 0;
		int position = 0;
		
				
		while (counter < 9 ) { 
			if (!spielerX) {
				System.out.print("SpielerIn O: ");
				position =keyScan.nextInt();
				counter++;			
				spielerX = true;
			}
			else {
				System.out.print("SpielerIn X: ");
				position =keyScan.nextInt();
				counter++;
				spielerX = false;
			}
			// Wertebereich checken
			if (0>=position  || position>=10)  {
				counter--;
				spielerX = true;
				System.out.println("Ouuu! Dein Wert muss zwischen 1-9 liegen, bitte wiederhole deine Eingabe.");
			}
			else {
				speichere(position, spielerX);
				printSpielfeld();
			}							  
		}
		
		keyScan.close();
	}
	
	static void init() {
		char [][] spielfeld = new char [3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				spielfeld[i][j] = '.';
			}
		}
	
	}
	
	static void speichere(int position, boolean spielerX) {
		spielfeld[getSpalte(position)][getZeile(position)] = getSymbol(spielerX);
	}

	static int getZeile(int position) {
		if (position ==1 || position ==4 || position ==7) {
			return 0;
		}
		else if (position ==2 || position ==5 || position ==8) {
			return 1;
		}
		
			return 2;
	}
	
	static int getSpalte(int position) {
		
		if (position <=3) {
			return 0;
		}
		else if (position <= 6 && position >=4 ) {
			return  1;
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
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(spielfeld[i][j]+".");
			}
			System.out.println("");
		}
	}
	static boolean hatGewonnen(boolean spielerX) {
		
		// TODO
	}
}
