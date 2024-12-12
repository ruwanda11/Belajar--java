import javax.swing.*;

public class WelcomePage extends JFrame {
    public WelcomePage() {
        // Mengatur judul dan ukuran jendela
        setTitle("Welcome");
        setSize(400, 400); // Ukuran lebih besar agar tombol tertata rapi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat tombol
        JButton btnDataMobil = new JButton("Lihat Data Mobil");
        JButton btnInsertData = new JButton("Tambah Data Mobil");
        JButton btnUpdateData = new JButton("Update Data Mobil");
        JButton btnDeleteData = new JButton("Hapus Data Mobil");

        // Mengatur posisi tombol (tidak tumpang tindih)
        btnDataMobil.setBounds(100, 50, 200, 40);
        btnInsertData.setBounds(100, 110, 200, 40);
        btnUpdateData.setBounds(100, 170, 200, 40);
        btnDeleteData.setBounds(100, 230, 200, 40);

        // Menambahkan tombol ke frame
        add(btnDataMobil);
        add(btnInsertData);
        add(btnUpdateData);
        add(btnDeleteData);

        // Mengatur layout ke null untuk posisi manual
        setLayout(null);
        setVisible(true);

        // Action listeners untuk tombol
        btnDataMobil.addActionListener(e -> new DataMobilPage());
        btnInsertData.addActionListener(e -> new InsertDataPage());

        // Tombol Update
        btnUpdateData.addActionListener(e -> {
            int id = 1; // Ganti dengan ID valid dari data mobil
            String currentJenis = "SUV"; // Ganti dengan jenis mobil valid
            new UpdateDataPage(id, currentJenis); // Pastikan kelas ini menerima parameter
        });

        // Tombol Delete
        btnDeleteData.addActionListener(e -> {
            int id = 1; // Ganti dengan ID valid dari data mobil yang ingin dihapus
            new DeleteDataPage(id); // Menyediakan ID untuk penghapusan
        });
    }

    public static void main(String[] args) {
        new WelcomePage();
    }
}
