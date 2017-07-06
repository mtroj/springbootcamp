package pl.com.sages.spring.bootcamp.model;

import org.hibernate.validator.constraints.NotEmpty;
import pl.com.sages.spring.bootcamp.validation.Currency;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Product {

    private int id;
    @Pattern(regexp = "\\w+")
    @NotEmpty
    private String name;
    @Currency(maxValue = 11_000)
    @Min(1)
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

}
