import java.util.ArrayList;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Spieler> player = new ArrayList<Spieler>();

		JTextField inputName = new JTextField();
		JTextField inputNumber = new JTextField();
		inputNumber.setText("");
		Object[] inputFields = { "Name", inputName, "Schätzwert", inputNumber };
		String[] buttons = { "Ok" };

		// Spieler einlesen
		int counter = 1;
		for (int i = 0; i < 5; i++) {
			JOptionPane.showOptionDialog(null, inputFields, "Schätzspiel: Spieler " + counter,
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);

			player.add(new Spieler(inputName.getText(), Integer.parseInt(inputNumber.getText())));
			inputName.setText("");
			inputNumber.setText("");
			counter++;
		}

		// Lösung einlesen
		String input = JOptionPane.showInputDialog(null, "Lösung", "Lösung eingeben", JOptionPane.DEFAULT_OPTION);

		// Eingabe mit Lösungen vergleichen

		int[] differenzen = new int[5];
		for (int i = 0; i < 5; i++) {
			differenzen[i] = Math.abs(player.get(i).getSchaetzwert() - Integer.parseInt(input));
		}

		int min = differenzen[0];
		for (int i = 0; i < 5; i++) {
			if (differenzen[i] < min) {
				min = differenzen[i];
			}
		}

		// Gewinner verkünden bei 1 Gewinner

		String[] gewinner = new String[5];
		for (int i = 0; i < 5; i++) {
			if (min == differenzen[i]) {
				gewinner[i] = player.get(i).getName();
			}
		}
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (gewinner[i] != null) {
				count++;
			}
		}
		String winner = gewinner[0];
		if (count == 1) {
			JOptionPane.showMessageDialog(null, "Gewonnen hat: " + winner, "Gewinner", JOptionPane.PLAIN_MESSAGE);

		}

		else {
			for (int i = 1; i < count; i++) {
				winner += ", " + gewinner[i];
			}
			JOptionPane.showMessageDialog(null, "Gewonnen hat: " + winner, "Gewinner", JOptionPane.PLAIN_MESSAGE);

		}

	}

}
