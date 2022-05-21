package controller;

import javax.swing.JPanel;

import vue.Login;

public class ControllerLogin {

	Login login;
	
	public JPanel getMenu() {

		// Création du contenu du menu client
		login = new Login();

		// Ajout des listeners aux boutons
//		addListener(login.getBtnConnection());

		// Remplissage des champs de texte avec le premier client de la BDD
//		remplissageChampsClient(false);

		// Renvoie du menu
		return login;

	}
}
