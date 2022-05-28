package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import persistence.Connexion;
import vue.FenetrePrincipale;

public class ControllerPrincipal {

	// Attributs d'instance
	// ---------------------
	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final String OUTPUT_FORMAT = "%-20s:%s";
	private FenetrePrincipale fenetrePrincipale;
	
	private int isAdmin;
	private static int isAdminResult;
	// --------------------
	// Méthodes d'instance
	// --------------------
	/**
	 * Instanciation de la fenêtre principale de l'application
	 */

	public JPanel getMenu() {
		// Instancier la fenêtre de l'application
		fenetrePrincipale = new FenetrePrincipale();

		// Rendre la fenêtre visible
		fenetrePrincipale.setVisible(true);

		// Ajouter les listeners aux boutons du menu supérieur
		addListener(fenetrePrincipale.getLogin().getBtnConnection(),
				fenetrePrincipale.getMenuSuperieur().getBtnDeconnection());

		return null;
	}

	private void addListener(JButton btnConnection, JButton btnDeconnection) {

		btnConnection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnConnection();

			}
		});
		btnDeconnection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnDeconnection();

			}
		});

	}

	public void actionBtnConnection() {

//		Récupération de l'email et du mot de passe saisi par l'utilisateur
		String email = fenetrePrincipale.getLogin().getTxtEmail().getText();
		String password = fenetrePrincipale.getLogin().getTxtPassword().getText();
		
		String sel = "sfghjk,nb7412368++=41";

		String passwordSel = password + sel;

		byte[] shaInBytes = digest(passwordSel.getBytes(UTF_8));
		
		String passwordHash = bytesToHex(shaInBytes);
		System.out.println("voici mon sha" +passwordHash);

//	Récupération des emails et mot de passe de la BDD
		// Ouvrir une connexion à la base de donnée pour récupérer les informations
		// client

		List myArrayListEmail = new ArrayList();
		List myArrayListPassword = new ArrayList();

		try (Connection connection = new Connexion().getConnection()) {
			String requete = "SELECT * FROM employe;";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(requete)) {
					int ligneEcriture = 1;

					while (resultSet.next()) { // tant qu'il y a un élément dans mon resultSet

						// Récupération des valeurs dans le résultat de la requête
						String emailClient = resultSet.getString("EMAIL");
						String motdepasse = resultSet.getString("MOTDEPASSE");
						isAdmin = resultSet.getInt("ISADMIN");

						myArrayListEmail.add(emailClient);
						myArrayListPassword.add(motdepasse);

						ligneEcriture += 1;
					}
				}
				System.out.println(myArrayListEmail);
				System.out.println(myArrayListPassword);

				System.out.println(email);
				Boolean isEmail = myArrayListEmail.contains(email);
				System.out.println(isEmail);
				System.out.println(password);
				Boolean isPassword = myArrayListPassword.contains(passwordHash);
				System.out.println(isPassword);

				if (isEmail && isPassword) {
					System.out.println("je suis"+isAdmin);
					isAdminResult = isAdmin;
					System.out.println(isAdminResult);
					getIsAdmin();
					if(isAdmin == 1) {
						System.out.println("Je suis admin");
					}else {
						System.out.println("je ne suis pas admin");
					}
//					yasmine.radouani@yahoo.fr
					
					updateFrame(new ControllerPagePrincipale().getMenu());
				} else {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Email ou mot de passe invalide");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void actionBtnDeconnection() {
		updateFrame(new ControllerPrincipal().getMenu());
	}

	private void updateFrame(JPanel panel) {

		// Supprimer le menu actuellement affiché
		JPanel conteneurPrincipal = fenetrePrincipale.getConteneurPrincipal();
		try {
			conteneurPrincipal.remove(1); // supprime le 2eme composant du conteneur, ici l'affichage contenant les
											// frames de nos menus
		} catch (ArrayIndexOutOfBoundsException e) {
			// l'application vient d'être lancée et aucun menu n'était encore affiché
		}

		// Ajouter le nouveau menu
		conteneurPrincipal.add(panel, BorderLayout.CENTER);

		// Mettre à jour l'affichage du conteneur principal
		conteneurPrincipal.revalidate();
	}

	public static byte[] digest(byte[] input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA3-256");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		byte[] result = md.digest(input);
		return result;
	}
	public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	public int getIsAdmin() {
		System.out.println("Je retourne dans controllerPrincipal que je suis admin "+isAdminResult);
		return isAdminResult;
	}
	

}
