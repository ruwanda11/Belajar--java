import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InsertDataPage extends JFrame {
    public InsertDataPage() {
        setTitle("Tambah Data Mobil");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblJenis = new JLabel("Jenis Mobil:");
        JTextField txtJenis = new JTextField();
        JButton btnSimpan = new JButton("Simpan");

        lblJenis.setBounds(30, 30, 100, 30);
        txtJenis.setBounds(130, 30, 120, 30);
        btnSimpan.setBounds(100, 80, 100, 30);

        add(lblJenis);
        add(txtJenis);
        add(btnSimpan);

        setLayout(null);
        setVisible(true);

        btnSimpan.addActionListener(e -> {
            String jenisMobil = txtJenis.getText();
            if (!jenisMobil.isEmpty()) {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mobil", "root", "");
                     PreparedStatement ps = connection.prepareStatement("INSERT INTO mobil (jenis) VALUES (?)")) {

                    ps.setString(1, jenisMobil);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
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
