public class Mobil {
    
    String merk = "merk";
    int kecepatan = 0;
    boolean mesinMenyala = false;

    public Mobil(String merk) {
        this.merk = merk;
        this.kecepatan = 0;
        this.mesinMenyala = false;
    }

    public void Nyalakan() {
        this.kecepatan = 5; // diubah jadi 5 km/jam
        this.mesinMenyala = true;
        System.out.println(merk + " : mesin dinyalakan, kecepatan : " + kecepatan + " km/jam");
    }

    public void Matikan() {
        this.kecepatan = 0;
        this.mesinMenyala = false;
        System.out.println(merk + " : mesin dimatikan, kecepatan : " + kecepatan + " km/jam");
    }

    public void gas() {
        if (mesinMenyala) {
            this.kecepatan += 5;
            System.out.println(merk + " : mesin digas, kecepatan : " + kecepatan + " km/jam");
        } else {
            System.out.println(merk + " : mesin belum menyala!");
        }
    }

    public void rem() {
        this.kecepatan -= 5;
        if (kecepatan < 0) kecepatan = 0; // biar tidak minus
        System.out.println(merk + " : direm, kecepatan : " + kecepatan + " km/jam");
    }
}