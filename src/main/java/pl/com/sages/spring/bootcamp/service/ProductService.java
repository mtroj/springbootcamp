package pl.com.sages.spring.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.sages.spring.bootcamp.dao.ProductDao;
import pl.com.sages.spring.bootcamp.model.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public Product findProduct(int id) {
        return productDao.findProduct(id);
    }

    public Product findProduct(String name) {
        return productDao.findProduct(name);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

}
