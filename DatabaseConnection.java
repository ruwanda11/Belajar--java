import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Memuat driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL koneksi ke database MySQL
            String url = "jdbc:mysql://localhost:3306/pt_bandicar";
            String user = "root";
            String password = "";

            // Mencoba membuat koneksi
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat menghubungkan ke database.");
            e.printStackTrace();
            return null;
        }
    }
}
