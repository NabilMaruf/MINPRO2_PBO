package driver; 

public abstract class Driver {
    private String nama;
    private String jenisKendaraan;
    private final int idDriver;
    private static int totalDriver = 0;

    public Driver(String nama, String jenisKendaraan, int idDriver) {
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
        this.idDriver = idDriver;
        totalDriver++;
    }

    public abstract void menampilkanDriver();

    public static void menampilkanTotalDriver() {
        System.out.println("Total Drivers: " + totalDriver);
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
}
