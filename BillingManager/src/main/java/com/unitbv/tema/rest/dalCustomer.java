package com.unitbv.tema.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class dalCustomer {

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


	public void insertCustomer(double discount,String billingType,String billingAddress,String creditCards) throws SQLException {
		createConnection();
		try {
			String query = null;
			query = "INSERT INTO Customer(discount,billingType,billingAddress,creditCards) VALUES(?, ?, ?, ?)";
			prepStmt = con.prepareStatement(query);
			prepStmt.setDouble(1, discount);
	        prepStmt.setString(2, billingType);
	        prepStmt.setString(3, billingAddress);
	        prepStmt.setString(4, creditCards);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(long i, double discount,String billingType,String billingAddress,String creditCards) throws SQLException {
		createConnection();
		try {
			String query = null;
			query = "UPDATE Customer SET discount=?, billingType=? billingAddress=? creditCards=? WHERE id = ?";
			prepStmt = con.prepareStatement(query);
			prepStmt.setLong(3, i);
	        prepStmt.setDouble(1, discount);
	        prepStmt.setString(2, billingType);
	        prepStmt.setString(3, billingAddress);
	        prepStmt.setString(4, creditCards);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Customer> getCustomers() throws SQLException
	{
		createConnection();
		List<Customer> Customers = new ArrayList<Customer>();
	    try
	    {
	    	stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
	        while (rs.next())
	        {
	        	long id=rs.getLong("id");
	        	Double discount=rs.getDouble("discount");
	        	String billingType=rs.getString("billingType");
	        	String billingAddress=rs.getString("billingAddress");
	        	String creditCards=rs.getString("creditCards");
	        	
	        	Customer cust=new Customer(id,discount, billingType,billingAddress,creditCards);
	        	Customers.add(cust);
	        }
	        rs.close();
	        stmt.close();
	        con.close();
	    } 
	    catch (SQLException e) 
	    {
	    	e.printStackTrace();
	    }
	    return Customers;
	}
	
	public void deleteCustomer(int id) throws SQLException
	{
		createConnection();
		try
	    {
			String query = "DELETE FROM Customer WHERE Id = ?";
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
