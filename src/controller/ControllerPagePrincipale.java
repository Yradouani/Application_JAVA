package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vue.MenuSuperieur;
import vue.PagePrincipale;

public class ControllerPagePrincipale{

	private JPanel conteneurPrincipal;
	PagePrincipale pagePrincipale;

	public JPanel getMenu() {


		// Cr�ation du contenu du menu client
		pagePrincipale = new PagePrincipale();
		
//		System.out.println(isAdminResult);
		

		addListener(pagePrincipale.getBtnClients(), pagePrincipale.getBtnProduits(), pagePrincipale.getBtnVentes(),
				pagePrincipale.getBtnFactures(), pagePrincipale.getBtnEmployes());
		// Remplissage des champs de texte avec le premier client de la BDD
//		remplissageChampsClient(false);

		// Renvoie du menu
		return pagePrincipale;

	}

	private void addListener(JButton btnClients, JButton btnProduits, JButton btnVentes, JButton btnFactures, JButton btnEmployes) {
		
		btnEmployes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnListeEmployes();

			}
		});
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

	private void actionBtnListeEmployes() {
		new ControllerListeDesEmployes().getListeDesEmployes();
	}
	
	private void actionBtnListeClients() {
		new ControllerListeDesClients().getListeDesClients();
	}
		

	private void actionBtnProduits() {
		new ControllerListeDesProduits().getListeDesProduits();

	}

	private void actionBtnVentes() {

		// Remplacer le menu affich� par le menu de gestion des produits
		new ControllerListeDesVentes().getListeDesVentes();

	}

	private void actionBtnFactures() {

		// Remplacer le menu affich� par le menu de gestion des produits
		new ControllerListeDesFactures().getListeDesFactures();

	}

//	
	private void updateFrame(JPanel panel) {

		// Supprimer le menu actuellement affich�
		try {
			conteneurPrincipal.remove(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			// l'application vient d'�tre lanc�e et aucun menu n'�tait encore affich�
		}

		// Ajouter le nouveau menu
		conteneurPrincipal.add(panel, BorderLayout.CENTER);

		// Mettre � jour l'affichage du conteneur principal
		conteneurPrincipal.revalidate();
	}
}