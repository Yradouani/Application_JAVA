package controller;

import javax.swing.JPanel;

import vue.VueFacture;

public class ControllerFacture {
	VueFacture vueFacture;

	public JPanel getMenu() {

		// Cr�ation du contenu du menu client
		vueFacture = new VueFacture();

		// Ajout des listeners aux boutons
//		addListener(login.getBtnConnection());

		// Remplissage des champs de texte avec le premier client de la BDD
//		remplissageChampsClient(false);

		// Renvoie du menu
		return vueFacture;

	}

}
