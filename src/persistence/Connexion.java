package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Connexion {

	//---------------------
	// Attributs d'instance
	//---------------------
	private Connection connection; // � importer de java.sql, et non de mariadb, pour ne pas perdre la flexibilit� octroy�e par la pr�sence du fichier de configuration

	//--------------
	// Constructeurs
	//--------------
	public Connexion() throws SQLException { 

		/*
		Pour �viter d'importer en dur le driver mariadb dans le code (ce qui aurait pour effet d'obliger � modifier
		le code source si l'on change de systeme de base de donn�es), on cr�er un fichier de configuration.
		Clic droit sur le projet, nouveau fichier, le  nommer conf.properties
		 */

		// R�cup�ration du fichier de configuration vers l'application
		Properties props = new Properties();
		try(FileInputStream fis = new FileInputStream("conf.properties")) { // placer l'instanciation de FileInputStream ici nous assure de fermer la ressource � la fin du try (cette syntaxe s'appelle try avec ressource), permettant une syntaxe plus compacte qu'avec un .close
			props.load(fis);
		} catch (FileNotFoundException e) {
			System.err.println("Fichier de configuration introuvable. V�rifiez qu'il est � la racine du projet.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// R�cup�ration des identifiant de connection
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");

		// Instanciation dynamique d'un driver
		try {
			Class.forName(props.getProperty("jdbc.driver.class")); // le driver est le composant qui impl�mente les m�thodes n�cessaires pour int�ragir avec la BDD pour laquelle il a �t� con�u
			// pas d'instanciation ici, la classe s'instancie automatiquement gr�ce un un bloc static contenu dans Driver.class dans le package org.mariadb.jdbc
		} catch (ClassNotFoundException e) {
			System.err.println("V�rifiez le nom du driver dans le fichier de configuration");
			e.printStackTrace();
		}

		// R�cup�ration de la connexion � la BDD gr�ce � la classe DriverManager
		this.connection = DriverManager.getConnection(url,login,password);
	}

	//-------------------
	// Getters et Setters
	//-------------------
	public Connection getConnection() {
		return connection;
	}

}

