import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class DataMobilPage extends JFrame {
    public DataMobilPage() {
        setTitle("Data Mobil");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "Jenis Mobil"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mobil", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM mobil")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String jenis = resultSet.getString("jenis");
                tableModel.addRow(new Object[]{id, jenis});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(scrollPane);
        setLayout(null);
        scrollPane.setBounds(20, 20, 450, 300);
        setVisible(true);
    }
}
