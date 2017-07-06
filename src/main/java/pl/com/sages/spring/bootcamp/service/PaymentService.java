package pl.com.sages.spring.bootcamp.service;

import org.springframework.stereotype.Component;
import pl.com.sages.spring.bootcamp.model.Product;

import java.util.List;

@Component
public class PaymentService {

    public void pay(List<Product> productList) {
        System.out.println("Płacę za: " + productList);
    }

}
