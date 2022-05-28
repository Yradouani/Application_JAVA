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

			// Propriétés de la fenêtre
			super(nomFenetre); 											// appel au constructeur de la classe parente en précisant le titre de la fenêtre
			this.setSize(1300,850); 										// taille de la fenêtre en pixels
			this.setLocationRelativeTo(null);							// faire apparaître la fenêtre centrée par rapport à l'écran
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// action à la fermeture de la fenêtre

			// Composants de la fenêtre
			// Conteneur principal et propriétés
			conteneurPrincipal = (JPanel) this.getContentPane(); 		// conteneur principal de la fenêtre

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
