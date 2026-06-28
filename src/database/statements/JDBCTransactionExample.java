package database.statements;

import java.sql.*;

import utils.DBUtils;

public class JDBCTransactionExample {

    public static void insertUsers() throws SQLException {

        String sql = "INSERT INTO users(first_name, last_name, email) VALUES (?, ?, ?)";

        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement(sql)) {

            try {
                // 🔴 start transaction
                conn.setAutoCommit(false);

                // User 1
                ps.setString(1, "John");
                ps.setString(2, "Doe");
                ps.setString(3, "john@example.com");
                ps.executeUpdate();

                // User 2
                ps.setString(1, "Jane");
                ps.setString(2, "Smith");
                ps.setString(3, "jane@example.com");
                ps.executeUpdate();

                // ✅ commit if everything is fine
                conn.commit();
                System.out.println("Transaction committed successfully!");

            } catch (Exception e) {

                conn.rollback();
                System.out.println("Transaction rolled back!");

                throw e;
            }
        }
    }
}