package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import persistence.Connexion;
import utile.Graphique;
import vue.ListeDesDonnees;

public class ControllerListeDesClients {

	ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
	String isAdmin = controllerPrincipal.getIsAdmin();
	public void getMenu() {

		getListeDesClients();
		System.out.println("IsAdmin"+isAdmin);


	}

	public void getListeDesClients() {

		ListeDesDonnees listeDesClients = new ListeDesDonnees("Liste des clients");
		listeDesClients.setVisible(true);

		// Récupération du conteneur de la fenêtre
		JPanel conteneurListe = listeDesClients.getConteneurPrincipal();

		// Ajout d'une scroll bar
		JPanel conteneurScrollable = new JPanel(new GridBagLayout()); // création du conteneur qui sera scrollable
		JScrollPane scrollPanel = new JScrollPane(conteneurScrollable); // ajout de la barre de scroll au conteneur
		conteneurListe.add(scrollPanel);

		// Spécification de positionnement
		GridBagConstraints c = new GridBagConstraints();

		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Identifiant"), c);

		Graphique.setMyConstraints(c, 1, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Nom"), c);

		Graphique.setMyConstraints(c, 2, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Prénom"), c);

		Graphique.setMyConstraints(c, 3, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Adresse"), c);

		Graphique.setMyConstraints(c, 4, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Code postal"), c);

		Graphique.setMyConstraints(c, 5, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Ville"), c);

		Graphique.setMyConstraints(c, 6, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Mail"), c);

		Graphique.setMyConstraints(c, 0, 1, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0));
		c.fill = GridBagConstraints.HORIZONTAL; // remplit toute la largeur de la cellule
		c.gridwidth = 8; // prend 8 cellules de large
		JSeparator s = new JSeparator();
		s.setBackground(Color.BLACK);
		conteneurScrollable.add(s, c);
		c.fill = GridBagConstraints.NONE; // RAZ (pas d'ajustement de taille)
		c.gridwidth = 1; // RAZ (prend 1 cellule de large)

		// Ouvrir une connexion à la base de donnée pour récupérer les informations
		// client
		try (Connection connection = new Connexion().getConnection()) {
			String requete = "SELECT * FROM employe;";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(requete)) {
					int ligneEcriture = 1;
					while (resultSet.next()) { // tant qu'il y a un élément dans mon resultSet

						// Récupération des valeurs dans le résultat de la requête
						String identifiant = resultSet.getString("ID_EMPLOYE");
						String nom = resultSet.getString("NOM");
						String prenom = resultSet.getString("PRENOM");
						String adresse = resultSet.getString("ADRESSE");
						String codePostal = resultSet.getString("CODE_POSTAL");
						String ville = resultSet.getString("VILLE");
						String mail = resultSet.getString("EMAIL");

						// Ajout des valeurs au conteneur pour affichage
						Graphique.setMyConstraints(c, 0, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(identifiant), c);

						Graphique.setMyConstraints(c, 1, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(nom), c);

						Graphique.setMyConstraints(c, 2, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(prenom), c);

						Graphique.setMyConstraints(c, 3, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(adresse), c);

						Graphique.setMyConstraints(c, 4, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(codePostal), c);

						Graphique.setMyConstraints(c, 5, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(ville), c);

						Graphique.setMyConstraints(c, 6, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(mail), c);
						
						if( isAdmin == "1") {
							Graphique.setMyConstraints(c, 7, ligneEcriture + 1, GridBagConstraints.WEST,
									new Insets(5, 0, 5, 10));
							conteneurScrollable.add(new JLabel("supprimer"), c);
						}

						ligneEcriture += 1;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
