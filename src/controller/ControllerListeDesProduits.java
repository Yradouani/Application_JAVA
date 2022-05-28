package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import persistence.Connexion;
import utile.Graphique;
import vue.ListeDesDonnees;

public class ControllerListeDesProduits {
	ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
	int isAdmin = controllerPrincipal.getIsAdmin();
	public void getMenu() {

		getListeDesProduits();

	}
	
	
	public void getListeDesProduits() {

		ListeDesDonnees listeDesProduits = new ListeDesDonnees("Liste des produits");
		listeDesProduits.setVisible(true);

		// Récupération du conteneur de la fenêtre
		JPanel conteneurListe = listeDesProduits.getConteneurPrincipal();

		// Ajout d'une scroll bar
		JPanel conteneurScrollable = new JPanel(new GridBagLayout()); // création du conteneur qui sera scrollable
		JScrollPane scrollPanel = new JScrollPane(conteneurScrollable); // ajout de la barre de scroll au conteneur
		conteneurListe.add(scrollPanel);

		// Spécification de positionnement
		GridBagConstraints c = new GridBagConstraints();

		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Code produit"), c);

		Graphique.setMyConstraints(c, 1, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Nom"), c);

		Graphique.setMyConstraints(c, 2, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Description"), c);

		Graphique.setMyConstraints(c, 3, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Prix"), c);

		Graphique.setMyConstraints(c, 4, 0, GridBagConstraints.CENTER, new Insets(5, 0, 10, 10));
		conteneurScrollable.add(new JLabel("Quantité"), c);

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
			String requete = "SELECT * FROM produit;";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(requete)) {
					int ligneEcriture = 1;
					while (resultSet.next()) { // tant qu'il y a un élément dans mon resultSet

						// Récupération des valeurs dans le résultat de la requête
						String code = resultSet.getString("CODE_PRODUIT");
						String nom = resultSet.getString("NOM");
						String description = resultSet.getString("DESCRIPTION_PRODUIT");
						String prix = resultSet.getString("PRIX") + "$";
						String quantite = resultSet.getString("QUANTITE");

						// Ajout des valeurs au conteneur pour affichage
						Graphique.setMyConstraints(c, 0, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(code), c);

						Graphique.setMyConstraints(c, 1, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(nom), c);

						Graphique.setMyConstraints(c, 2, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(description), c);

						Graphique.setMyConstraints(c, 3, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(prix), c);

						Graphique.setMyConstraints(c, 4, ligneEcriture + 1, GridBagConstraints.WEST,
								new Insets(5, 0, 5, 10));
						conteneurScrollable.add(new JLabel(quantite), c);
						
						if( isAdmin == 1) {
							Graphique.setMyConstraints(c, 5, ligneEcriture + 1, GridBagConstraints.WEST,
									new Insets(5, 0, 5, 10));
							conteneurScrollable.add(new JButton("supprimer"), c);
							
							Graphique.setMyConstraints(c, 6, ligneEcriture + 1, GridBagConstraints.WEST,
									new Insets(5, 0, 5, 10));
							conteneurScrollable.add(new JButton("modifier"), c);
						} 
//							yasmine.radouani@yahoo.fr
							

						ligneEcriture += 1;
					}
					Graphique.setMyConstraints(c, 1, ligneEcriture + 1, GridBagConstraints.WEST,
							new Insets(5, 0, 5, 10));
					conteneurScrollable.add(new JButton("Ajouter un nouveau produit"), c);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
