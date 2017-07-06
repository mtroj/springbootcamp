package pl.com.sages.spring.bootcamp.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.sages.spring.bootcamp.model.Product;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ProductServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void should_add_product() throws Exception {
        //given
        String productName = "stojak";
        int price = 10;
        int count1 = jdbcTemplate.queryForObject("Select count(*) from product where name like ?", Integer.class, productName);

        // when
        productService.addProduct(productName, price);

        // then
        int count2 = jdbcTemplate.queryForObject("Select count(*) from product where name like ?", Integer.class, productName);
        assertThat(count2 - count1).isEqualTo(1);
    }

    @Test
    public void should_get_product_by_id() throws Exception {
        //given
        productService.addProduct("lskjf", 120);
        Integer id = jdbcTemplate.queryForObject("select max(id) from product", Integer.class);

        // when
        Product product = productService.findProduct(id);

        // then
        assertThat(product).isNotNull();
    }

}