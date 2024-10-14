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
