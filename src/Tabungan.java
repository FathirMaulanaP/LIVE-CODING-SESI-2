public class Tabungan extends Rekening {
    private double bungaTahunan; // dalam persen

    public Tabungan(String nama, String nomor, double saldo, double bunga) {
        super(nama, nomor, saldo);
        this.bungaTahunan = bunga;
    }

    // Hitung bunga langsung (tanpa simulasi per bulan)
    public void hitungBunga(int bulan) {
        double bunga = (bungaTahunan / 100 / 12) * saldo * bulan;
        this.saldo += bunga;

        System.out.println("Bunga ditambahkan: Rp " + bunga);

        // ✅ simpan ke riwayat
        riwayat.add("Bunga " + bulan + " bulan: Rp " + bunga);
    }

    // ✅ Simulasi bunga bulanan dengan perulangan
    public void simulasiBungaBulanan(int bulan) {
        double bungaPerBulan = bungaTahunan / 100 / 12;

        for (int i = 1; i <= bulan; i++) {
            double bunga = saldo * bungaPerBulan;
            saldo += bunga;

            String log = "Bulan ke-" + i +
                         " | Bunga: Rp " + bunga +
                         " | Saldo: Rp " + saldo;

            System.out.println(log);

            // ✅ simpan ke riwayat
            riwayat.add(log);
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bunga Tahunan: " + bungaTahunan + "%");
    }
}