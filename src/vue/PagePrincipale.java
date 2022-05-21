package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import utile.Graphique;

@SuppressWarnings("serial")
public class PagePrincipale extends JPanel{
	private JButton 	btnClients		= new JButton("Clients");
	private JButton 	btnProduits		= new JButton("Produits");
	private JButton 	btnVentes		= new JButton("Ventes");
	private JButton 	btnFactures		= new JButton("Factures");
	
	public PagePrincipale(){

		
		// Propriétés du conteneur
		this.setLayout(new GridBagLayout());


		// Ajouts des composants au conteneur
		GridBagConstraints c = new GridBagConstraints(); // pour le positionnerment des composants

		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.CENTER, new Insets(0,0,0,0));
		this.add(getButtonPanel(),c); // boutons

	}
	
	private JPanel getButtonPanel() {

		// Création du conteneur
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Ajout des composants
		c.insets = new Insets(0, 3, 0, 3);
		panel.add(btnClients,c);
		panel.add(btnProduits,c);
		panel.add(btnVentes,c);
		panel.add(btnFactures,c);

		return panel;

	}

	public JButton getBtnClients() {
		return btnClients;
	}

	public void setBtnClients(JButton btnClients) {
		this.btnClients = btnClients;
	}

	public JButton getBtnProduits() {
		return btnProduits;
	}

	public void setBtnProduits(JButton btnProduits) {
		this.btnProduits = btnProduits;
	}

	public JButton getBtnVentes() {
		return btnVentes;
	}

	public void setBtnVentes(JButton btnVentes) {
		this.btnVentes = btnVentes;
	}

	public JButton getBtnFactures() {
		return btnFactures;
	}

	public void setBtnFactures(JButton btnFactures) {
		this.btnFactures = btnFactures;
	}

}
