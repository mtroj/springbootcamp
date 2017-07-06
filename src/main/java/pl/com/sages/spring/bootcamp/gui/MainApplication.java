package pl.com.sages.spring.bootcamp.gui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.sages.spring.bootcamp.model.Product;
import pl.com.sages.spring.bootcamp.service.ProductService;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring.class);

        ProductService productService = applicationContext.getBean(ProductService.class);
        List<Product> products = productService.findAllProducts();

        for (Product product : products) {
            System.out.println(product.getName());
        }

        applicationContext.close();
    }

}
