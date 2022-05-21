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

		// Propri�t�s de la fen�tre
		super("ACME Corp"); 									// appel au constructeur de la classe parente en pr�cisant le titre de la fen�tre
		this.setSize(900,450); 										// taille de la fen�tre en pixels
		this.setLocationRelativeTo(null);							// faire appara�tre la fen�tre centr�e par rapport � l'�cran
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 	// action � la fermeture de la fen�tre

		
		// Composants de la fen�tre
		// Conteneur principal
		conteneurPrincipal = (JPanel) this.getContentPane(); // conteneur principal de la fen�tre, en borderlayout par d�faut

		// Cr�ation du visuel du menu
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