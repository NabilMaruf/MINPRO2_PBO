package driver;

public final class Motor extends Driver {
    private final String jenisMotor;

    public Motor(String nama, String jenisKendaraan, int idDriver, String jenisMotor){
        super(nama, jenisKendaraan, idDriver);
        this.jenisMotor = jenisMotor;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    @Override
    public void menampilkanDriver() {
        System.out.println("Nama Driver: " + getNama());
        System.out.println("Jenis Kendaraan: " + getJenisKendaraan());
        System.out.println("Jenis Motor: " + jenisMotor);
        System.out.println("ID Driver: " + getIdDriver());
    }
}
