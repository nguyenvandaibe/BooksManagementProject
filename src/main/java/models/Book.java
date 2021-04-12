package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

public class Book extends BaseModel {

	public Book() throws ClassNotFoundException, NamingException, SQLException {
		super();
	}

	public Book(Integer id, String name, String publisher, Integer price)
			throws ClassNotFoundException, NamingException, SQLException {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}

	private Integer id;
	private String name;
	private String publisher;
	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Tim kiem sach theo ten
	 * 
	 * @param nameString
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NamingException
	 */
	public ArrayList<Book> search(String key) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "select * from books where name like '%" + key + "%' or publisher like '%" + key + "%';";

		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery(sql);

		ArrayList<Book> books = new ArrayList<Book>();

		while (resultSet.next()) {
			books.add(new Book(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("publisher"),
					resultSet.getInt("price")));
		}

		this.connection.close();
		return books;
	}

	/**
	 * Get a book by id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NamingException
	 */
	public Book getById(Integer id) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "select * from books where id = " + id;
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);

		if (resultSet.next()) {
			return new Book(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("publisher"),
					resultSet.getInt("price"));
		}
		return new Book();
	}

	/**
	 * Update a book
	 * 
	 * @param id
	 * @param name
	 * @param publisher
	 * @param price
	 * @return
	 * @throws SQLException
	 */
	public boolean update(Integer id, String name, String publisher, Integer price) {
		try {
			String sql = "update books set name = '" + name + "', publisher = '" + publisher + "', price = '" + price
					+ "' where id = '" + id + "';";
			System.out.println(sql);
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);

			System.out.println("update book return " + true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete a book by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean destroy(Integer id) {
		try {
			String sql = "delete from books where id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
