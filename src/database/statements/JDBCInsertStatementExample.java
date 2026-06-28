package database.statements;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtils;

public class JDBCInsertStatementExample {
	public static void insert() throws SQLException {
		String query = "INSERT INTO users (first_name, last_name, email) VALUES (?,?,?)";
		try (var conn = DBUtils.getConnection();
				
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, "isa");
			ps.setString(2, "fsa");
			ps.setString(3, "isafsa@gmail.com");
			
			int rows = ps.executeUpdate();
			System.out.println(rows);
			
		}
	}
}
