package ua.alex.springApp.service;

import ua.alex.springApp.model.Product;

import java.util.List;


public interface ProductService {
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product getById(int id);
    List<Product> getAll();
}
