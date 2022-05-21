package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vue.MenuSuperieur;
import vue.PagePrincipale;

public class ControllerPagePrincipale {

	private JPanel conteneurPrincipal;
	PagePrincipale pagePrincipale;

	public JPanel getMenu() {

		this.conteneurPrincipal = conteneurPrincipal;

		// Création du contenu du menu client
		pagePrincipale = new PagePrincipale();

		addListener(pagePrincipale.getBtnClients(), pagePrincipale.getBtnProduits(), pagePrincipale.getBtnVentes(),
				pagePrincipale.getBtnFactures());
		// Remplissage des champs de texte avec le premier client de la BDD
//		remplissageChampsClient(false);

		// Renvoie du menu
		return pagePrincipale;

	}

	private void addListener(JButton btnClients, JButton btnProduits, JButton btnVentes, JButton btnFactures) {
		
		btnClients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnListeClients();

			}
		});
		btnProduits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnProduits();

			}
		});
		btnVentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnVentes();

			}
		});
		btnFactures.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnFactures();

			}
		});

	}

	private void actionBtnDeconnection() {
		ControllerPrincipal controllerPrincipal;
		
	}
	private void actionBtnListeClients() {
		new ControllerListeDesClients().getListeDesClients();
	}

		

	private void actionBtnProduits() {
		new ControllerListeDesProduits().getListeDesProduits();

	}

	private void actionBtnVentes() {

		// Remplacer le menu affiché par le menu de gestion des produits
		updateFrame(new ControllerVente().getMenu());

	}

	private void actionBtnFactures() {

		// Remplacer le menu affiché par le menu de gestion des produits
		updateFrame(new ControllerFacture().getMenu());

	}

//	
	private void updateFrame(JPanel panel) {

		// Supprimer le menu actuellement affiché
		try {
			conteneurPrincipal.remove(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			// l'application vient d'être lancée et aucun menu n'était encore affiché
		}

		// Ajouter le nouveau menu
		conteneurPrincipal.add(panel, BorderLayout.CENTER);

		// Mettre à jour l'affichage du conteneur principal
		conteneurPrincipal.revalidate();
	}
}