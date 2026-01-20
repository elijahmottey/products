package LIV.coveda.product.controller;


import LIV.coveda.product.entities.Product;
import LIV.coveda.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @QueryMapping
    public List<Product> getAllProductsByCategory1(@Argument String category) {
        return productService.getAllProductsByCategory(category);
    }

    @QueryMapping
    public List<Product> getAllProducts1() {
        return productService.getAllProducts();
    }
}
