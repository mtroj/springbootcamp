package pl.com.sages.spring.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.com.sages.spring.bootcamp.model.Product;
import pl.com.sages.spring.bootcamp.service.ProductService;

import javax.validation.Valid;

@Controller
public class ProductsController {


    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("show-products.html")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.findAllProducts());
        return modelAndView;
    }

    @RequestMapping(value = "product.html", method = RequestMethod.GET)
    public ModelAndView showAddProductForm(@RequestParam(name = "id", required = false) Integer id) {
        if (id != null) {
            ModelAndView modelAndView = new ModelAndView("editProduct");
            modelAndView.addObject(productService.findProduct(id));
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject(new Product());
        return modelAndView;
    }

    @RequestMapping(value = "product.html", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("addProduct");
        }
        productService.addProduct(product);
        return new ModelAndView("addProductConfirmation", "product", product);
    }

}
