package vue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class MenuSuperieur extends JToolBar {
	
	//---------------------
		// Attributs d'instance
		//---------------------
		private JButton btnDeconnection = new JButton("Se déconnecter");

		//--------------
		// Constructeurs
		//--------------
		public MenuSuperieur() { 										// est un JToolBar

			// Propriétés du conteneur
			this.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));	// conteneur en flowlayout avec margin de 100 sur l'axe des x et 10 sur l'axe des y

			// Ajout des boutons au conteneur
			this.add(btnDeconnection);

		}

		//---------------------
		// Getters et Setters
		//---------------------
		public JButton getBtnDeconnection() {
			return btnDeconnection;
		}

		public void setBtnDeconnection(JButton btnDeconnection) {
			this.btnDeconnection = btnDeconnection;
		}

}
