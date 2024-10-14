package driver;

public final class Mobil extends Driver {
    private final String jenisMobil;

    public Mobil(String nama, String jenisKendaraan, int idDriver, String jenisMobil){
        super(nama, jenisKendaraan, idDriver);
        this.jenisMobil = jenisMobil;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    @Override
    public void menampilkanDriver() {
        System.out.println("Nama Driver: " + getNama());
        System.out.println("Jenis Kendaraan: " + getJenisKendaraan());
        System.out.println("Jenis Mobil: " + jenisMobil);
        System.out.println("ID Driver: " + getIdDriver());
    }
}
