package interfaces;

// Interface untuk operasi CRUD
public interface CRUDOperations<T> {
    void create(T obj);
    void read();
    void update(int id, T obj);
    void delete(int id);
}
