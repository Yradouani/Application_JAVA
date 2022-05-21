package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame{

	private JPanel conteneurPrincipal;
	private MenuSuperieur menuSuperieur;
	private Login login;
//	private PanelImage panelImage;
	
	public FenetrePrincipale() {

		// Propriétés de la fenêtre
		super("ACME Corp"); 									// appel au constructeur de la classe parente en précisant le titre de la fenêtre
		this.setSize(900,450); 										// taille de la fenêtre en pixels
		this.setLocationRelativeTo(null);							// faire apparaître la fenêtre centrée par rapport à l'écran
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// action à la fermeture de la fenêtre

		
		// Composants de la fenêtre
		// Conteneur principal
		conteneurPrincipal = (JPanel) this.getContentPane(); // conteneur principal de la fenêtre, en borderlayout par défaut

		// Création du visuel du menu
		menuSuperieur = new MenuSuperieur();
		login = new Login();
//		panelImage = new PanelImage();
		
	// Ajout du menu au conteneur principal
		conteneurPrincipal.add(menuSuperieur, BorderLayout.NORTH);
		conteneurPrincipal.add(login, BorderLayout.CENTER);
//		conteneurPrincipal.add(panelImage, BorderLayout.CENTER);
	}
	
	
		//-------------------
		// Getters et Setters
		//-------------------
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