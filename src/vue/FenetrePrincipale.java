package vue;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame {

	private JPanel conteneurPrincipal;
	private MenuSuperieur menuSuperieur;
	private Login login;
//	private PanelImage panelImage;
	Image img = Toolkit.getDefaultToolkit()
			.getImage("C:\\Users\\yasmi\\eclipse-workspace\\Application_MSPR\\image.jpg");

	public FenetrePrincipale() {

		// Propriétés de la fenêtre
		super("ACME Corp"); 									// appel au constructeur de la classe parente en précisant le titre de la fenêtre
		this.setSize(900,450); 										// taille de la fenêtre en pixels
		this.setLocationRelativeTo(null);							// faire apparaître la fenêtre centrée par rapport à l'écran
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// action à la fermeture de la fenêtre

		
		// Composants de la fenêtre
		// Conteneur principal

//		Ajout d'une image en background
//		this.setContentPane(new JPanel() {
//			@Override
//			public void paintComponent(Graphics g) {
//			      try {
////			         BufferedImage image = ImageIO.read(new File("C:\\Users\\yasmi\\eclipse-workspace\\Application_MSPR\\image.jpg"));
//			         BufferedImage img = ImageIO.read(new File("C:\\Users\\yasmi\\eclipse-workspace\\Application_MSPR\\img.png"));
////			         g.drawImage(image, 0, 0, null);
//			         super.paintComponent(g);
//			         Graphics2D g2d = (Graphics2D) g;
//			         int x = (this.getWidth() - img.getWidth(null)) / 2;
//			         int y = (this.getHeight() - img.getHeight(null)) / 2;
//			         g2d.drawImage(img, x, y, null);
//			      }
//			      catch (IOException e) {
//			         e.printStackTrace();
//			      }
//			   }
//		});
		
		conteneurPrincipal = (JPanel) this.getContentPane(); // conteneur principal de la fenêtre, en borderlayout par défaut
		// Création du visuel du menu
		menuSuperieur = new MenuSuperieur();
		login = new Login();
		
	// Ajout du menu au conteneur principal

		conteneurPrincipal.add(menuSuperieur, BorderLayout.CENTER);
		conteneurPrincipal.add(login, BorderLayout.CENTER);
	}

	// -------------------
	// Getters et Setters
	// -------------------
	public JPanel getConteneurPrincipal() {
		return conteneurPrincipal;
	}

	public void setConteneurPrincipal(JPanel conteneurPrincipal) {
		this.conteneurPrincipal = conteneurPrincipal;
	}

	public MenuSuperieur getMenuSuperieur() {
		return menuSuperieur;
	}

	public void setMenuSuperieur(MenuSuperieur menuSuperieur) {
		this.menuSuperieur = menuSuperieur;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}