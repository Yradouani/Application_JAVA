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
	private Connection connection; // à importer de java.sql, et non de mariadb, pour ne pas perdre la flexibilité octroyée par la présence du fichier de configuration

	//--------------
	// Constructeurs
	//--------------
	public Connexion() throws SQLException { 

		/*
		Pour éviter d'importer en dur le driver mariadb dans le code (ce qui aurait pour effet d'obliger à modifier
		le code source si l'on change de systeme de base de données), on créer un fichier de configuration.
		Clic droit sur le projet, nouveau fichier, le  nommer conf.properties
		 */

		// Récupération du fichier de configuration vers l'application
		Properties props = new Properties();
		try(FileInputStream fis = new FileInputStream("conf.properties")) { // placer l'instanciation de FileInputStream ici nous assure de fermer la ressource à la fin du try (cette syntaxe s'appelle try avec ressource), permettant une syntaxe plus compacte qu'avec un .close
			props.load(fis);
		} catch (FileNotFoundException e) {
			System.err.println("Fichier de configuration introuvable. Vérifiez qu'il est à la racine du projet.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Récupération des identifiant de connection
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");

		// Instanciation dynamique d'un driver
		try {
			Class.forName(props.getProperty("jdbc.driver.class")); // le driver est le composant qui implémente les méthodes nécessaires pour intéragir avec la BDD pour laquelle il a été conçu
			// pas d'instanciation ici, la classe s'instancie automatiquement grâce un un bloc static contenu dans Driver.class dans le package org.mariadb.jdbc
		} catch (ClassNotFoundException e) {
			System.err.println("Vérifiez le nom du driver dans le fichier de configuration");
			e.printStackTrace();
		}

		// Récupération de la connexion à la BDD grâce à la classe DriverManager
		this.connection = DriverManager.getConnection(url,login,password);
	}

	//-------------------
	// Getters et Setters
	//-------------------
	public Connection getConnection() {
		return connection;
	}

}

