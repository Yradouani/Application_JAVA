package application;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	Connection connection;
	Statement statement;
	String SQL;
	String url;
	String username;
	String password;
	Socket client;
	int Port;
	String Host;
	
	public void database (String url, String username, String password, String Host, int Port) {
		
		this.url = url;
		this.username = username;
		this.password = password;
		this.Host = Host;
		this.Port = Port;
	}
	
//	Connexion à la base de donnée MariaDb
	public Connection databaseConnection () {
		
		try {
			Class.forName("com.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e)
		{System.err.println(e.getMessage());}
		return connection;
	}
	
//	Fermer la base de données
	public Connection closeConnection() {
		try {
			connection.close();
		} catch (Exception e)
		{System.err.println(e.getMessage());}
		return connection;
	}
	
//	public ResultSet executionQuery(String sql) {
//		public void connexionDatabase();
//		ResultSet resultSet = null;
//		try {
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql);
//			System.out.println(sql);
//		} catch (SQLException ex)
//		{System.err.println(ex);}
//		return resultSet;
//	}
}
