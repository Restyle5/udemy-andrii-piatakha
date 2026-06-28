package database.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtils;

public class JDBCSelectStatementExample {
	
	
	public static void select() throws SQLException{
		String query = "SELECT * FROM users";
		
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			try (ResultSet rs = statement.executeQuery(query)) {
				while (rs.next()) {
					System.out.println("=================");
					System.out.println("ID:\t\t" + rs.getInt("ID"));
					System.out.println("First Name:\t" + rs.getString("first_name"));
					System.out.println("Last Name:\t" + rs.getString("last_name"));
					System.out.println("Email:\t\t" + rs.getString("email"));
				}
			};
			
		}
	}
}
