import javax.swing.*;
import java.sql.*;

public class UpdateDataPage extends JFrame {
    public UpdateDataPage(int id, String currentJenis) {
        setTitle("Update Data Mobil");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblJenis = new JLabel("Jenis Mobil:");
        JTextField txtJenis = new JTextField(currentJenis);
        JButton btnUpdate = new JButton("Update");

        lblJenis.setBounds(30, 30, 100, 30);
        txtJenis.setBounds(130, 30, 120, 30);
        btnUpdate.setBounds(100, 80, 100, 30);

        add(lblJenis);
        add(txtJenis);
        add(btnUpdate);

        setLayout(null);
        setVisible(true);

        btnUpdate.addActionListener(e -> {
            String jenisMobil = txtJenis.getText();
            if (!jenisMobil.isEmpty()) {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mobil", "root", "");
                     PreparedStatement ps = connection.prepareStatement("UPDATE mobil SET jenis = ? WHERE id = ?")) {

                    ps.setString(1, jenisMobil);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jenis Mobil tidak boleh kosong!");
            }
        });
    }
}

