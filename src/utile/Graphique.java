package utile;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Graphique {

	/**
	 * Permet de paramétrer la position des composants dans le 
	 * GridBagLayout
	 */
	public static void setMyConstraints(GridBagConstraints c, int gridx, int gridy, int anchor, Insets insets) { // position colonne, position ligne, position dans la cellule, margin
		c.gridx = gridx;
		c.gridy = gridy;
		c.anchor = anchor;
		c.insets = insets;
	}
}
