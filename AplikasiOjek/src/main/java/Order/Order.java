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