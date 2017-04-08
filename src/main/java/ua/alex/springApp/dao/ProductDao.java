package ua.alex.springApp.dao;

import ua.alex.springApp.model.Product;

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
