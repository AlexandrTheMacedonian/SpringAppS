package ua.alex.SpringApp.service;

import ua.alex.SpringApp.model.Product;

import java.util.List;


public interface ProductService {
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product getById(int id);
    List<Product> getAll();
}
