package manager;

import driver.Driver;
import interfaces.CRUDOperations;
import java.util.ArrayList;

public final class DriverManager implements CRUDOperations<Driver> {
    private final ArrayList<Driver> drivers = new ArrayList<>();

    @Override
    public void create(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver berhasil ditambahkan!");
    }

    @Override
    public void read() {
        if (drivers.isEmpty()) {
            System.out.println("Tidak ada driver tersedia.");
        } else {
            for (Driver driver : drivers) {
                driver.menampilkanDriver();
                System.out.println("------------------");
            }
            Driver.menampilkanTotalDriver();
        }
    }

    @Override
    public void update(int id, Driver updatedDriver) {
        boolean found = false;
        for (Driver driver : drivers) {
            if (driver.getIdDriver() == id) {
                if (!updatedDriver.getNama().equals("Tidak diubah")) {
                    driver.setNama(updatedDriver.getNama());
                }
                if (!updatedDriver.getJenisKendaraan().equals("Tidak diubah")) {
                    driver.setJenisKendaraan(updatedDriver.getJenisKendaraan());
                }
                found = true;
                System.out.println("Driver berhasil di-update!");
                break;
            }
        }
        if (!found) {
            System.out.println("Driver dengan ID tersebut tidak ditemukan.");
        }
    }

    @Override
    public void delete(int id) {
        Driver driverToRemove = null;
        for (Driver driver : drivers) {
            if (driver.getIdDriver() == id) {
                driverToRemove = driver;
                break;
            }
        }

        if (driverToRemove != null) {
            drivers.remove(driverToRemove);
            System.out.println("Driver berhasil dihapus.");
        } else {
            System.out.println("Driver dengan ID tersebut tidak ditemukan.");
        }
    }

    public Driver getDriverById(int id) {
        for (Driver driver : drivers) {
            if (driver.getIdDriver() == id) {
                return driver;
            }
        }
        return null;
    }
}
