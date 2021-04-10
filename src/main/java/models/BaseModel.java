package models;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import database.MySqlDatabaseConnection;

public class BaseModel {
	protected Connection connection;

	public BaseModel() throws ClassNotFoundException, NamingException, SQLException {
		this.connection = (new MySqlDatabaseConnection()).getConnection();
	}

}
