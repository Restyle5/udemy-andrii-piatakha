package chapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import database.statements.JDBCInsertStatementExample;
import database.statements.JDBCSelectStatementExample;
import database.statements.JDBCTransactionExample;
import database.statements.JDBCUpdateStatementExample;


public class ChapterThirtyFive implements Chapter{

	private Note notes;
	
	// demo purpose, suppose there's a class/service to covers DB connection.
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "test_jdbc";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	
	public ChapterThirtyFive() {
		ChapterNote  notes = new ChapterNote(Arrays.asList("Implement JDBC mysql REPO & Establish Connection", "Statement, Prepared Statement, CallableStatement"));
		this.notes = notes;
	}
	
	@Override
	public String getChapterName() {
		return "Java Database Connectivity (JDBC)";
	}

	@Override
	public List<String> getNotes() {
		return notes.getNotes();
	}

	@Override
	public void execute() {
//		topicEstablishConnection();
//		topicTransactionStatement();
		topicStatements();
//		topicUpdateStatement();
//		topicInsertStatement();
	}
	
	public static void topicEstablishConnection()
	{
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

//		try {
//			Class.forName(MYSQL_JDBC_DRIVER_NAME);
//		} catch (ClassNotFoundException e) {
//			System.out.println("Can't find JDBC driver. Please, make sure JDBC driver is added to a classpath.");
//			return;
//		}

		try (Connection connection = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);) {

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
	
	public static void topicStatements() {
		try {
		JDBCSelectStatementExample.select();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void topicUpdateStatement()
	{
		try {
		JDBCUpdateStatementExample.update();
		}catch(SQLException e) { e.printStackTrace();}
	}
	
	public static void topicInsertStatement()
	{
		// sample
		try {
			JDBCInsertStatementExample.insert();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void topicTransactionStatement() 
	{
		try { JDBCTransactionExample.insertUsers(); } catch(SQLException e) { e.printStackTrace();}
	}

}
