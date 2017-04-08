package ua.alex.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alex.springApp.dao.ProductDao;
import ua.alex.springApp.model.Product;

import java.util.List;

/**
 * service layer.
 */

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Override
    @Transactional
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return productDao.getAll();
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
