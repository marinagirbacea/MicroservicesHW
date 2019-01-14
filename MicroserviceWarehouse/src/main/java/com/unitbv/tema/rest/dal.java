package com.unitbv.tema.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dal {
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement prepStmt = null;

	private void createConnection() {
		try {
			// incarca dinamic in memorie JDBC-ul (Java Database Connectivity) pt sqlite
			Class.forName("org.sqlite.JDBC");
			// setez conexiunea cu JDBC-ul sqlite si fisierul de baze de date LoginDB
			con = DriverManager.getConnection("jdbc:sqlite:/C:/databases/warehouse.db");
			// desetez modul auto-commit pe baza de date - pentru ca sa execut fiecare
			// tranzactie separat
			// daca auto-commit este true, nu mai am nevoie de commit la sf fiecarei
			// interogari
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertProduct(double stock, String location, boolean availability, double volume,
			String storageCondition) {
		createConnection();
		try {
			String query = null;
			query = "INSERT INTO Product(stock, location,availability,volume, storageCondition) VALUES(?, ?,?,?,?)";
			prepStmt = con.prepareStatement(query);
			prepStmt.setDouble(1, stock);
			prepStmt.setString(2, location);
			prepStmt.setBoolean(3, availability);
			prepStmt.setDouble(4, volume);
			prepStmt.setString(5, storageCondition);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(int id, double stock, String location, boolean availability, double volume,
			String storageCondition) {
		createConnection();
		try {
			String query = null;
			query = "UPDATE Product SET stock=?, location=?, availability=?, volume=?, storageCondition=?  WHERE id = ?";
			prepStmt = con.prepareStatement(query);
			prepStmt.setInt(6, id);
			prepStmt.setDouble(1, stock);
			prepStmt.setString(2, location);
			prepStmt.setBoolean(3, availability);
			prepStmt.setDouble(4, volume);
			prepStmt.setString(5, storageCondition);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProducts() {
		createConnection();
		List<Product> Products = new ArrayList<Product>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
			while (rs.next()) {
				int id = rs.getInt("id");
				Double stock = rs.getDouble("stock");
				String location = rs.getString("location");
				Boolean availability = rs.getBoolean("availability");
				Double volume = rs.getDouble("volume");
				String storageCondition = rs.getString("storageCondition");
				Product prod = new Product(id, stock, location, availability, volume, storageCondition);
				Products.add(prod);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Products;
	}

	public void deleteProduct(int id) {
		createConnection();
		try {
			String query = "DELETE FROM Product WHERE Id = ?";
			prepStmt = con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
