import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rekening> daftarRekening = new ArrayList<>();

        // Membuat rekening
        Tabungan tabungan = new Tabungan("Andi", "T101", 10000000, 5);
        Giro giro = new Giro("Budi", "G201", 5000000, 2000000);
        Deposito deposito = new Deposito("Citra", "D301", 10000000, 12, 0.06);

        daftarRekening.add(tabungan);
        daftarRekening.add(giro);
        daftarRekening.add(deposito);

        // ==============================
        // SIMULASI TRANSAKSI
        // ==============================

        // Setor
        tabungan.setor(500000, true);

        // Transfer (Giro → Tabungan kena biaya 5000)
        giro.transfer(tabungan, 1000000);

        // Simulasi bunga bulanan (loop)
        tabungan.simulasiBungaBulanan(3);

        // Penarikan deposito
        deposito.tarik(1000000);

        // ==============================
        // TAMPILKAN DATA
        // ==============================
        System.out.println("\n--- DAFTAR SEMUA REKENING ---");

        Rekening tertinggi = daftarRekening.get(0);
        Rekening terendah = daftarRekening.get(0);

        for (Rekening r : daftarRekening) {
            r.tampilkanInfo();
            System.out.println("--------------------");

            if (r.saldo > tertinggi.saldo) tertinggi = r;
            if (r.saldo < terendah.saldo) terendah = r;
        }

        // Statistik saldo
        System.out.println("\nSaldo Tertinggi: " + tertinggi.namaPemilik + " (Rp " + tertinggi.saldo + ")");
        System.out.println("Saldo Terendah: " + terendah.namaPemilik + " (Rp " + terendah.saldo + ")");

        // ==============================
        // ✅ CETAK RIWAYAT TRANSAKSI
        // ==============================
        System.out.println("\n--- RIWAYAT TRANSAKSI TABUNGAN ---");
        tabungan.cetakRiwayat();

        System.out.println("\n--- RIWAYAT TRANSAKSI GIRO ---");
        giro.cetakRiwayat();

        System.out.println("\n--- RIWAYAT TRANSAKSI DEPOSITO ---");
        deposito.cetakRiwayat();
    }
}