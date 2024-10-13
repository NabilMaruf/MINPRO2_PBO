# Biodata
Nama : Muhammad Nabil Ma'ruf\
NIM : 2309116035\
Sistem Informasi A

# Deskripsi Program
Penjelasan singkat Program\
Program Sistem Manajemen Ojek Online, adalah program yang terdiri dari 5 package yaitu AplikasiOjek, Driver, Order, Manager & Interface yang masing-masing packagenya terdapat class dan fungsi masing-masing. Program ini juga bertujuan untuk menerapkan Manajemen pada Ojek Online juga bisa digunakan untuk mengorder ojek online dengan dua kriteria kendaraan, yaitu mobil dan motor.

# Garis besar alur Program
Program ini saya buat dengan menggunakan 5 package dan 7 class beserta 1 class interface, disini terdapat 1 main program yaitu adalah class APLIKASIOJEK dan ada 2 submain program yaitu section DRIVER dan section ORDER. Karena itu, saya jadi memisahkan pengerjaan atau proses di dalam Package Manager yaitu ada sistem Order dan sistem Driver yang di sambungkan dengan Interface untuk membuat sistem CRUD. Di dalam package Driver, memiliki 1 superclass Driver yang abstrak bertujuan untuk di wariskan (Enheritence) ke 2 subclassnya yaitu Mobil dan Motor.

# Source Code & Package
![image](https://github.com/user-attachments/assets/ab702640-466d-42a1-a2ca-ccba4069c82b)

Terdapat 5 package, 7 Class dan 1 Interface


# Package com.mycompany.aplikasiojek
## AplikasiOjek (Main Program)
```
package com.mycompany.aplikasiojek;

import driver.Driver;
import driver.Mobil;
import driver.Motor;
import order.Order;
import manager.DriverManager;
import manager.OrderManager;
import java.util.Scanner;

public final class AplikasiOjek {
    private final DriverManager driverManager = new DriverManager();
    private final OrderManager orderManager = new OrderManager();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AplikasiOjek app = new AplikasiOjek();
        app.run();
    }

    public void run() {
        int pilihan;

        do {
            System.out.println("=== Sistem Manajemen Ojek Online ===");
            System.out.println("1. Menambahkan Driver Mobil");
            System.out.println("2. Menambahkan Driver Motor");
            System.out.println("3. Menampilkan Drivers");
            System.out.println("4. Update Driver");
            System.out.println("5. Hapus Driver");
            System.out.println("6. Order Ojek");
            System.out.println("7. Menampilkan Orderan");
            System.out.println("8. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                scanner.next();
                System.out.print("Masukkan Pilihan Anda: ");
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahDriverMobil();
                    break;
                case 2:
                    tambahDriverMotor();
                    break;
                case 3:
                    driverManager.read();
                    break;
                case 4:
                    updateDriver();
                    break;
                case 5:
                    deleteDriver();
                    break;
                case 6:
                    tambahOrder();
                    break;
                case 7:
                    orderManager.read();
                    break;
                case 8:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 8);

        scanner.close();
    }

    // Method untuk menambah Driver Mobil
    private void tambahDriverMobil() {
        System.out.print("Masukkan nama Driver: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jenis kendaraan: ");
        String jenisKendaraan = scanner.nextLine();
        System.out.print("Masukkan ID Driver: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            scanner.next(); 
            System.out.print("Masukkan ID Driver: ");
        }
        int idDriver = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan jenis mobil: ");
        String jenisMobil = scanner.nextLine();
        Driver mobil = new Mobil(nama, jenisKendaraan, idDriver, jenisMobil);
        driverManager.create(mobil);
    }

    // Method untuk menambah Driver Motor
    private void tambahDriverMotor() {
        System.out.print("Masukkan nama Driver: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jenis kendaraan: ");
        String jenisKendaraan = scanner.nextLine();
        System.out.print("Masukkan ID Driver: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            scanner.next(); 
            System.out.print("Masukkan ID Driver: ");
        }
        int idDriver = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan jenis motor: ");
        String jenisMotor = scanner.nextLine();
        Driver motor = new Motor(nama, jenisKendaraan, idDriver, jenisMotor);
        driverManager.create(motor);
    }

    // Method untuk update Driver
    private void updateDriver() {
        System.out.print("Masukkan ID Driver yang ingin di-update: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            scanner.next(); 
            System.out.print("Masukkan ID Driver yang ingin di-update: ");
        }
        int updateID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama baru (kosongkan jika tidak ingin mengubah): ");
        String newName = scanner.nextLine();
        System.out.print("Masukkan jenis kendaraan baru (kosongkan jika tidak ingin mengubah): ");
        String newVehicleType = scanner.nextLine();

        // Membuat objek Driver sementara untuk update
        Driver updatedDriver = new Motor(
                newName.isEmpty() ? "Tidak diubah" : newName,
                newVehicleType.isEmpty() ? "Tidak diubah" : newVehicleType,
                updateID,
                "Tidak diubah" // JenisMotor atau jenisMobil tidak diubah di sini
        );
        driverManager.update(updateID, updatedDriver);
    }

    // Method untuk menghapus Driver
    private void deleteDriver() {
        System.out.print("Masukkan ID Driver yang ingin dihapus: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            scanner.next(); 
            System.out.print("Masukkan ID Driver yang ingin dihapus: ");
        }
        int deleteID = scanner.nextInt();
        scanner.nextLine();
        driverManager.delete(deleteID);
    }

    // Method untuk menambah Order
    private void tambahOrder() {
        System.out.print("Masukkan Nama Pelanggan: ");
        String namaCustomer = scanner.nextLine();
        System.out.print("Masukkan Lokasi Penjemputan: ");
        String pickupLocation = scanner.nextLine();
        System.out.print("Masukkan Tujuan: ");
        String destination = scanner.nextLine();
        Order order = new Order(namaCustomer, pickupLocation, destination);
        orderManager.create(order);
    }
}

```

# Package Driver
## Driver (Superclass dari Mobil & Motor)
```
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
```

## Mobil (Subclass dari Driver)
```
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
```

## Motor (Subclass dari Driver)
```
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

```

# Package Order
## Order
```
package order;

public final class Order {
    private String namaCustomer;
    private String pickupLocation;
    private String destinasi;

    public Order(String namaCustomer, String pickupLocation, String destinasi) {
        this.namaCustomer = namaCustomer;
        this.pickupLocation = pickupLocation;
        this.destinasi = destinasi;
    }

    public void menampilkanOrderan() {
        System.out.println("Nama Customer: " + namaCustomer);
        System.out.println("Lokasi Penjemputan: " + pickupLocation);
        System.out.println("Destinasi: " + destinasi);
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestinasi() {
        return destinasi;
    }

    public void setDestinasi(String destinasi) {
        this.destinasi = destinasi;
    }
}
```

# Package Manage
## Order Manager
```
package manager;

import order.Order;
import interfaces.CRUDOperations;
import java.util.ArrayList;

public final class OrderManager implements CRUDOperations<Order> {
    private final ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void create(Order order) {
        orders.add(order);
        System.out.println("Order berhasil ditambahkan!");
    }

    @Override
    public void read() {
        if (orders.isEmpty()) {
            System.out.println("Tidak ada orderan tersedia.");
        } else {
            for (Order order : orders) {
                order.menampilkanOrderan();
                System.out.println("------------------");
            }
        }
    }

    @Override
    public void update(int id, Order updatedOrder) {
        // Implementasi update untuk Order jika diperlukan
        // Untuk demonstrasi, mengasumsikan 'id' sesuai dengan index+1
        if (id > 0 && id <= orders.size()) {
            orders.set(id - 1, updatedOrder);
            System.out.println("Order berhasil di-update!");
        } else {
            System.out.println("Order dengan ID tersebut tidak ditemukan.");
        }
    }

    @Override
    public void delete(int id) {
        if (id > 0 && id <= orders.size()) {
            orders.remove(id - 1);
            System.out.println("Order berhasil dihapus.");
        } else {
            System.out.println("Order dengan ID tersebut tidak ditemukan.");
        }
    }
}
```

## Driver Manager
```
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
```

# Package Interfaces
## Interface
```
package interfaces;

// Interface untuk operasi CRUD
public interface CRUDOperations<T> {
    void create(T obj);
    void read();
    void update(int id, T obj);
    void delete(int id);
}
```

# Menu utama
![image](https://github.com/user-attachments/assets/c6c3f559-70d6-4850-9f99-21610bc3599b)

Akan menampilkan pilihan dan menu-menu apa saja yang ada di dalam program

# Pilihan 1
![image](https://github.com/user-attachments/assets/db6fa03d-df7f-44d4-8fc8-a4fa27a8dd6a)

Pilihan pertama akan menampilkan menu dan inputan untuk Menambahkan Driver Mobil

# Pilihan 2
![image](https://github.com/user-attachments/assets/f2ba1feb-e8e0-444f-bfe2-6b17f2b9cb27)

Pilihan kedua akan menampilkan menu dan inputan untuk Menambahkan Driver Motor

# Pilihan 3
![image](https://github.com/user-attachments/assets/03c2a316-7a5e-4a04-83d3-36a552ce7288)

Pilihan ketiga akan menampilkan semua driver yang ada

# Pilihan 4
![image](https://github.com/user-attachments/assets/baa388ea-2d16-4e4c-a487-7a8e91b9c4b0)

Pilihan keempat akan menampilkan menu atau inputan untuk menginput update driver yang baru

# Pilihan 5
![image](https://github.com/user-attachments/assets/aecd6150-150f-42c6-bf6c-bf9e6cc44cd3)

Pilihan kelima akan otomatis menghapus driver sesuai dengan ID drivernya

# Pilihan 6
![image](https://github.com/user-attachments/assets/fa2da178-3cdc-4411-883a-04fa31d407dc)

Pilihan keenam akan menampilkan menu dan inputan untuk Mengorder ojek

# Pilihan 7
![image](https://github.com/user-attachments/assets/7c438f18-b321-403e-9518-ad0b44990310)

Pilihan ketujuh akan menampilkan orderan yang sedang ada

# Pilihan 8
![image](https://github.com/user-attachments/assets/1a638315-a4d7-46be-9923-f49549f1c957)

Pilihan kedelapan adalah keluar dari program (exit)














