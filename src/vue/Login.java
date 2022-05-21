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
public class Login extends JPanel {

	private JLabel lblEmail = new JLabel("E-mail");
	private JLabel lblPassword = new JLabel("Password");

	private JTextField txtEmail = new JTextField(15);
	private JTextField txtPassword = new JTextField(40);

	private JButton btnConnection = new JButton("Connection");
	

	// --------------
	// Constructeurs
	// --------------
	public Login() {

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

	// ---------------------
	// Méthodes d'instance
	// ---------------------
	/**
	 * Spécifie les propriétés des composants du conteneur
	 */
	private void setComponentsProperties() {

		// Modifier les couleurs
		Color couleurLabels = Color.BLUE;
		lblEmail.setForeground(couleurLabels);
		lblPassword.setForeground(couleurLabels);

	}

	private JPanel getFieldPanel() {

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Connectez-vous à votre compte"));
		GridBagConstraints c = new GridBagConstraints();

		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.EAST, new Insets(5, 0, 0, 10));
		panel.add(lblEmail, c);

		Graphique.setMyConstraints(c, 1, 0, GridBagConstraints.WEST, new Insets(5, 0, 0, 0));
		panel.add(txtEmail, c);

		Graphique.setMyConstraints(c, 0, 1, GridBagConstraints.EAST, new Insets(5, 0, 0, 10));
		panel.add(lblPassword, c);

		Graphique.setMyConstraints(c, 1, 1, GridBagConstraints.WEST, new Insets(5, 0, 0, 0));
		panel.add(txtPassword, c);

		return panel;

	}

	private JPanel getButtonPanel() {

		// Création du conteneur
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Ajout des composants
		c.insets = new Insets(0, 3, 0, 3);
		panel.add(btnConnection, c);

		return panel;

	}
	
	public JButton getBtnConnection() {
		return btnConnection;
	}

	public void setBtnPrecedent(JButton btnConnection) {
		this.btnConnection = btnConnection;
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}
}
