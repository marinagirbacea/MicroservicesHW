package com.unitbv.tema.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class dalProduct {

	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement prepStmt = null;

	private void createConnection() throws SQLException
	{
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/billing", "postgres", "parola");
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	public void insertProduct(double price, double discount, double taxes) throws SQLException {
		createConnection();
		try {
			String query = null;
			query = "INSERT INTO Product(price, discount,taxes) VALUES(?, ?, ?)";
			prepStmt = con.prepareStatement(query);
			prepStmt.setDouble(1, price);
	        prepStmt.setDouble(2, discount);
	        prepStmt.setDouble(3, taxes);
	        
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(long i, double price, double discount, double taxes) throws SQLException {
		createConnection();
		try {
			String query = null;
			query = "UPDATE Product SET price=?, discount=? taxes=? WHERE id = ?";
			prepStmt = con.prepareStatement(query);
			prepStmt.setLong(3, i);
	        prepStmt.setDouble(1, price);
	        prepStmt.setDouble(2, discount);
	        prepStmt.setDouble(3, taxes);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Product> getProducts() throws SQLException
	{
		createConnection();
		List<Product> Products = new ArrayList<Product>();
	    try
	    {
	    	stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
	        while (rs.next())
	        {
	        	long id=rs.getLong("id");
	        	double price=rs.getDouble("price");
	        	double discount=rs.getDouble("discount");
	        	double taxes=rs.getDouble("taxes");
	        	Product prod=new Product(id,price, discount, taxes);
	        	Products.add(prod);
	        }
	        rs.close();
	        stmt.close();
	        con.close();
	    } 
	    catch (SQLException e) 
	    {
	    	e.printStackTrace();
	    }
	    return Products;
	}
	
	public void deleteProduct(int id) throws SQLException
	{
		createConnection();
		try
	    {
			String query = "DELETE FROM Product WHERE Id = ?";
			prepStmt = con.prepareStatement(query);
	        prepStmt.setInt(1, id);
	        prepStmt.execute();	
	        prepStmt.close();
	        con.commit();
	        con.close();
	    } 
	    catch (SQLException e) 
	    {
	    	e.printStackTrace();
	    }
	}
}
