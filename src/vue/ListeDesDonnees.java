package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ListeDesDonnees extends JFrame{

	//---------------------
		// Attributs d'instance
		//---------------------
		private JPanel conteneurPrincipal;

		//--------------
		// Constructeurs
		//--------------
		public ListeDesDonnees(String nomFenetre) {

			// Propri�t�s de la fen�tre
			super(nomFenetre); 											// appel au constructeur de la classe parente en pr�cisant le titre de la fen�tre
			this.setSize(1300,850); 										// taille de la fen�tre en pixels
			this.setLocationRelativeTo(null);							// faire appara�tre la fen�tre centr�e par rapport � l'�cran
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// action � la fermeture de la fen�tre

			// Composants de la fen�tre
			// Conteneur principal et propri�t�s
			conteneurPrincipal = (JPanel) this.getContentPane(); 		// conteneur principal de la fen�tre

		}

		//-------------------
		// Getters et Setters
		//-------------------
		public JPanel getConteneurPrincipal() {
			return conteneurPrincipal;
		}

		public void setConteneurPrincipal(JPanel conteneurPrincipal) {
			this.conteneurPrincipal = conteneurPrincipal;
		}
}
