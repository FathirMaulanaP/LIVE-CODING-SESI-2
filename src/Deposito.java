public class Deposito extends Rekening {
    private int jangkaWaktuBulan;
    private double sukuBunga; // [cite: 39]

    public Deposito(String nama, String nomor, double saldo, int jangka, double bunga) {
        super(nama, nomor, saldo);
        this.jangkaWaktuBulan = jangka;
        this.sukuBunga = bunga;
    }

    public void hitungBunga() { // [cite: 40]
        double bunga = (sukuBunga / 100) * saldo * jangkaWaktuBulan;
        this.saldo += bunga;
    }

    @Override
    public void tarik(double jumlah) {
        double denda = 0.10 * saldo;
        this.saldo -= (jumlah + denda);

        riwayat.add("Tarik Deposito: Rp " + jumlah + " (Denda: Rp " + denda + ")");

        System.out.println("Penarikan sebelum jatuh tempo! Denda 10%: Rp " + denda);
}
}