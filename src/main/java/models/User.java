package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class User extends BaseModel {

	public User() throws ClassNotFoundException, NamingException, SQLException {
		super();
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * Check user does exist in database
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean login(String username, String password) throws SQLException {
		String sql = "select * from users where username='" + username + "' and password='" + password + "'";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			this.connection.close();
			return true;
		}

		return false;
	}
}
