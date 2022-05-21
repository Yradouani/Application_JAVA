package controller;

import javax.swing.JPanel;
import vue.VueVente;

public class ControllerVente {

	VueVente vueVente;

	public JPanel getMenu() {

		// Création du contenu du menu client
		vueVente = new VueVente();

		// Ajout des listeners aux boutons
//		addListener(login.getBtnConnection());

		// Remplissage des champs de texte avec le premier client de la BDD
//		remplissageChampsClient(false);

		// Renvoie du menu
		return vueVente;

	}

}
