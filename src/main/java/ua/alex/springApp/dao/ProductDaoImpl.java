package ua.alex.springApp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.alex.springApp.model.Product;

import java.util.List;

/**
 * Data accsess object.
 */

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);


    private SessionFactory sessionFactory;


    @Override
    public void add(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Product successfully added./nProduct info:/n"+product);
    }

    @Override
    public void update(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product successfully updated./nProduct info:/n"+product);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        if (product!=null) session.delete(product);
        logger.info("Product successfully removed./nProduct info:/n"+product);
    }

    @Override
    public Product getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        logger.info("Successfully got product by id.");
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        logger.info("Successfully got all products.");
        return products;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
