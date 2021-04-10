package database;

import java.sql.Connection;

public interface IDatabaseConnection {
	public Connection getConnection();
}
