package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MySqlDatabaseConnection implements IDatabaseConnection {
	private Connection connection;
	private String dbHost;
	private String dbUser;
	private String dbPassword;

	/**
	 * Constructor Get database's information from web.xml
	 * 
	 * @throws NamingException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public MySqlDatabaseConnection() throws NamingException, ClassNotFoundException, SQLException {
		Context envContext = (Context) (new InitialContext()).lookup("java:comp/env");
		dbHost = (String) envContext.lookup("DB_HOST");
		dbUser = (String) envContext.lookup("DB_USER");
		dbPassword = (String) envContext.lookup("DB_PASSWORD");

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(dbHost, dbUser, dbPassword);
	}

	/**
	 * Getter of connection
	 */
	@Override
	public Connection getConnection() {
		return connection;
	}

}
