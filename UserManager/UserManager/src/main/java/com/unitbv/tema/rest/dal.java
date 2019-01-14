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
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(
					"jdbc:sqlite:/C:/databases/UserManagement.db");
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCustomer(String nume, String email, String address,String password) {
		createConnection();
		try {
			String query = null;
			query = "INSERT INTO Customer(name, email,address,password) VALUES(?, ?)";
			prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, nume);
	        prepStmt.setString(2, email);
	        prepStmt.setString(3, address);
	        prepStmt.setString(4, password);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(long i, String nume, String mail, String address,String password) {
		createConnection();
		try {
			String query = null;
			query = "UPDATE Customer SET name=?, email=?, address=?, password=? WHERE id = ?";
			prepStmt = con.prepareStatement(query);
			prepStmt.setLong(3, i);
	        prepStmt.setString(1, nume);
	        prepStmt.setString(2, mail);
	        prepStmt.setString(3, address);
	        prepStmt.setString(4, password);
			prepStmt.execute();
			prepStmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Customer> getCustomers()
	{
		createConnection();
		List<Customer> customers = new ArrayList<Customer>();
	    try
	    {
	    	stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
	        while (rs.next())
	        {
	        	long id=rs.getLong("id");
	        	String nume=rs.getString("name");
	        	String mail=rs.getString("email");
	        	String address=rs.getString("address");
	        	String password=rs.getString("password");
	        	Customer cust=new Customer(id,nume, mail,address,password);
	        	customers.add(cust);
	        }
	        rs.close();
	        stmt.close();
	        con.close();
	    } 
	    catch (SQLException e) 
	    {
	    	e.printStackTrace();
	    }
	    return customers;
	}
	
	public void deleteCustomer(int id)
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
