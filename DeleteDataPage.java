import javax.swing.*;
import java.sql.*; // Untuk koneksi database

public class DeleteDataPage extends JFrame {
    public DeleteDataPage(int id) {
        setTitle("Delete Data Mobil");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menampilkan pesan konfirmasi
        JLabel lblConfirmation = new JLabel("Apakah Anda yakin ingin menghapus mobil dengan ID " + id + "?");
        JButton btnDelete = new JButton("Hapus");

        lblConfirmation.setBounds(30, 30, 250, 30);
        btnDelete.setBounds(100, 100, 100, 30);

        add(lblConfirmation);
        add(btnDelete);

        setLayout(null);
        setVisible(true);

        btnDelete.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mobil", "root", "");
                 PreparedStatement ps = connection.prepareStatement("DELETE FROM mobil WHERE id = ?")) {

                ps.setInt(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                dispose(); // Menutup jendela setelah penghapusan
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.");
            }
        });
    }
}
