package vue;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utile.Graphique;

public class PanelImage extends JFrame {
	private JLabel lblImage = new JLabel(
			new ImageIcon("C:\\Users\\yasmi\\eclipse-workspace\\Application_MSPR\\image.jpg"));

	public PanelImage() {
		
		// Propriétés du conteneur
		this.setLayout(new GridBagLayout());

		// Ajouts des composants au conteneur
		GridBagConstraints c = new GridBagConstraints(); // pour le positionnerment des composants
		
		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.CENTER, new Insets(0,0,0,0));
		this.add(getFieldPanel(),c); // champs

					
		
//		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\yasmi\\eclipse-workspace\\Application_MSPR\\image.jpg")));
//		this.setLayout(new FlowLayout());
//		add(L1);
//		setSize(900, 800);
//		
	}

	private JPanel getFieldPanel() {

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setLayout(new FlowLayout());
		GridBagConstraints c = new GridBagConstraints();

		Graphique.setMyConstraints(c, 0, 0, GridBagConstraints.EAST, new Insets(5, 0, 0, 10));
		panel.add(lblImage, c);

		return panel;

	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

}
