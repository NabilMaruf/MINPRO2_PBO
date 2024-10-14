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