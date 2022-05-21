package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utile.Graphique;

@SuppressWarnings("serial")
public class VueClient extends JPanel {
	private JLabel 		lblIdentifiant 		= new JLabel("Identifiant");
	private JLabel 		lblNom 				= new JLabel("Nom");
	private JLabel 		lblPrenom 			= new JLabel("Prenom");
	private JLabel 		lblAdresse 			= new JLabel("Adresse");
	private JLabel 		lblCodePostal 		= new JLabel("Code postal");
	private JLabel 		lblVille 			= new JLabel("Ville");
	private JLabel 		lblMail				= new JLabel("EMail");
	
	private JTextField 	txtIdentifiant 		= new JTextField(15);
	private JTextField 	txtNom 				= new JTextField(40);
	private JTextField 	txtPrenom 			= new JTextField(40);
	private JTextField 	txtAdresse			= new JTextField(40);
	private JTextField 	txtCodePostal 		= new JTextField(10);
	private JTextField 	txtVille 			= new JTextField(40);
	private JTextField 	txtMail 			= new JTextField(40);
	
	private JButton 	btnPrecedent		= new JButton("Précédent");
	
	public VueClient() {

		// Propriétés du conteneur
		this.setLayout(new GridBagLayout());

		// Propriétés des composants
		setComponentsProperties();

		// Ajouts des composants au conteneur
		GridBagConstraints c = new GridBagConstraints(); // pour le positionnerment des composants
		
		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.CENTER, new Insets(0,0,0,0));
		this.add(getFieldPanel(),c); // champs

		Graphique.setMyConstraints(c, 0, 1, GridBagConstraints.CENTER, new Insets(10,0,0,0));
		this.add(getButtonPanel(),c); // boutons

	}
	
	//---------------------
		// Méthodes d'instance
		//---------------------
		/**
		 * Spécifie les propriétés des composants du conteneur
		 */
		private void setComponentsProperties() {

			// Modifier les couleurs
			Color couleurLabels	= Color.BLUE;
			lblIdentifiant.setForeground(couleurLabels);
			lblNom.setForeground(couleurLabels);
			lblPrenom.setForeground(couleurLabels);
			lblAdresse.setForeground(couleurLabels);
			lblCodePostal.setForeground(couleurLabels);
			lblVille.setForeground(couleurLabels);
			lblMail.setForeground(couleurLabels);

		}
		
		/**
		 * Créé les vues de chaque ligne du conteneur principal
		 * @return
		 */
		private JPanel getFieldPanel() {
			
			JPanel panel = new JPanel(new GridBagLayout());
			panel.setBorder(BorderFactory.createTitledBorder("Informations client"));
			GridBagConstraints c = new GridBagConstraints();
			
			Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblIdentifiant,c);
			
			Graphique.setMyConstraints(c, 1, 0, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtIdentifiant,c);
			
			Graphique.setMyConstraints(c, 0, 1, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblNom,c);
			
			Graphique.setMyConstraints(c, 1, 1, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtNom,c);
			
			Graphique.setMyConstraints(c, 0, 2, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblPrenom,c);
			
			Graphique.setMyConstraints(c, 1, 2, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtPrenom,c);
			
			Graphique.setMyConstraints(c, 0, 3, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblAdresse,c);
			
			Graphique.setMyConstraints(c, 1, 3, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtAdresse,c);
			
			Graphique.setMyConstraints(c, 0, 4, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblCodePostal,c);
			
			Graphique.setMyConstraints(c, 1, 4, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtCodePostal,c);
			
			Graphique.setMyConstraints(c, 0, 5, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblVille,c);
			
			Graphique.setMyConstraints(c, 1, 5, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtVille,c);
			
			Graphique.setMyConstraints(c, 0, 6, GridBagConstraints.EAST, new Insets(5,0,0,10));
			panel.add(lblMail,c);
			
			Graphique.setMyConstraints(c, 1, 6, GridBagConstraints.WEST, new Insets(5,0,0,0));
			panel.add(txtMail,c);
			
			return panel;

		}
		
		private JPanel getButtonPanel() {

			// Création du conteneur
			JPanel panel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			// Ajout des composants
			c.insets = new Insets(0, 3, 0, 3);
			panel.add(btnPrecedent,c);

			return panel;

		}

		public JTextField getTxtIdentifiant() {
			return txtIdentifiant;
		}

		public void setTxtIdentifiant(JTextField txtIdentifiant) {
			this.txtIdentifiant = txtIdentifiant;
		}

		public JTextField getTxtNom() {
			return txtNom;
		}

		public void setTxtNom(JTextField txtNom) {
			this.txtNom = txtNom;
		}

		public JTextField getTxtPrenom() {
			return txtPrenom;
		}

		public void setTxtPrenom(JTextField txtPrenom) {
			this.txtPrenom = txtPrenom;
		}

		public JTextField getTxtAdresse() {
			return txtAdresse;
		}

		public void setTxtAdresse(JTextField txtAdresse) {
			this.txtAdresse = txtAdresse;
		}

		public JTextField getTxtCodePostal() {
			return txtCodePostal;
		}

		public void setTxtCodePostal(JTextField txtCodePostal) {
			this.txtCodePostal = txtCodePostal;
		}

		public JTextField getTxtVille() {
			return txtVille;
		}

		public void setTxtVille(JTextField txtVille) {
			this.txtVille = txtVille;
		}

		public JTextField getTxtMail() {
			return txtMail;
		}

		public void setTxtMail(JTextField txtMail) {
			this.txtMail = txtMail;
		}

		public JButton getBtnPrecedent() {
			return btnPrecedent;
		}

		public void setBtnPrecedent(JButton btnPrecedent) {
			this.btnPrecedent = btnPrecedent;
		}

	
}
