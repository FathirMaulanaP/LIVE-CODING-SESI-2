import java.util.ArrayList;

public class Rekening {
    protected String namaPemilik;
    protected String nomorRekening;
    protected double saldo;

    // Riwayat transaksi harus
    //  di dalam class
    protected ArrayList<String> riwayat = new ArrayList<>();

    public Rekening(String nama, String nomor, double saldoAwal) {
        this.namaPemilik = nama;
        this.nomorRekening = nomor;
        this.saldo = saldoAwal;
    }

    // Setor tunai
    public void setor(double jumlah) {
        this.saldo += jumlah;
        riwayat.add("Setor: Rp " + jumlah);
    }

    // Setor via transfer
    public void setor(double jumlah, boolean transfer) {
        if (transfer) {
            double biayaAdmin = 5000;
            this.saldo += (jumlah - biayaAdmin);
            riwayat.add("Setor transfer: Rp " + jumlah + " (admin: " + biayaAdmin + ")");
        } else {
            setor(jumlah);
        }
    }

    // Tarik
    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            this.saldo -= jumlah;
            riwayat.add("Tarik: Rp " + jumlah);
        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }

    // ✅ Transfer (harus di dalam class)
    public void transfer(Rekening tujuan, double jumlah) {
        if (jumlah <= saldo) {
            double biayaAdmin = 0;

            if (this instanceof Giro && tujuan instanceof Tabungan) {
                biayaAdmin = 5000;
            }

            this.saldo -= (jumlah + biayaAdmin);
            tujuan.saldo += jumlah;

            riwayat.add("Transfer ke " + tujuan.nomorRekening + ": Rp " + jumlah);
            tujuan.riwayat.add("Transfer dari " + this.nomorRekening + ": Rp " + jumlah);

            System.out.println("Transfer berhasil: Rp " + jumlah);
            if (biayaAdmin > 0) {
                System.out.println("Biaya admin: Rp " + biayaAdmin);
            }
        } else {
            System.out.println("Saldo tidak cukup untuk transfer!");
        }
    }

    // Cetak riwayat
    public void cetakRiwayat() {
        System.out.println("=== Riwayat Transaksi ===");
        for (String r : riwayat) {
            System.out.println(r);
        }
    }

    public void tampilkanInfo() {
        System.out.println("Pemilik: " + namaPemilik);
        System.out.println("No. Rekening: " + nomorRekening);
        System.out.printf("Saldo: Rp %,.2f%n", saldo);
    }
}