package database.statements;

import java.sql.SQLException;
import java.sql.Statement;
import utils.DBUtils;

public class JDBCUpdateStatementExample {
	
	public static void  update() throws SQLException {
		String query = "UPDATE users SET last_name = \"sa0\" WHERE id = 2";
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}
}
