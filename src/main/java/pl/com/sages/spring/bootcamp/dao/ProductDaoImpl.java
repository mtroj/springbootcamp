package pl.com.sages.spring.bootcamp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.com.sages.spring.bootcamp.model.Product;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Product> productRowMapper = (rs, rowNum) -> {

        Long id = rs.getLong("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");

        return new Product(id, name, price);
    };

    @Override
    public void addProduct(Product product) {
        jdbcTemplate.update("INSERT INTO product(name, price) VALUES (?,?)", product.getName(), product.getPrice());
    }

    @Override
    public Product findProduct(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?", productRowMapper, id);
    }

    @Override
    public Product findProduct(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE name LIKE ?", productRowMapper, name);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product", productRowMapper);
    }

}