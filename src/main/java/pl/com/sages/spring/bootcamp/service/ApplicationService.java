package pl.com.sages.spring.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pl.com.sages.spring.bootcamp.model.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentService paymentService;

    @Value("${kodolamacz.app.name}")
    private String applicationName;

    public ApplicationService() {
        System.out.println("Tworzę się :)");
    }

    @PostConstruct
    public void afterCreate(){
        System.out.println("Stworzyłem beana!!!");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Usuwam beana!!!");
    }

    public void doShopping() {
        System.out.println("Application name: " + applicationName);

        Product product1 = productService.findProduct("konewka");
        Product product2 = productService.findProduct("szpadel");
        Product product3 = productService.findProduct("kosiarka");
        Product product4 = productService.findProduct("taczki");

        List<Product> productList = new ArrayList<>(4);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        cartService.addToCart(productList);

        paymentService.pay(productList);

        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

}
