package ua.alex.SpringApp.dao;

import ua.alex.SpringApp.model.Product;

import java.util.List;

/**
 * Data accsess object.
 */

public interface ProductDao {
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product getById(int id);
    List<Product> getAll();
}
