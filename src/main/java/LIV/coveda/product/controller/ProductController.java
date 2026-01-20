package LIV.coveda.product.controller;


import LIV.coveda.product.entities.Product;
import LIV.coveda.product.entities.ProductDto;
import LIV.coveda.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @QueryMapping
    public List<Product> getAllProducts1(@Argument int page, @Argument int size) {
        return productService.getAllProducts(page, size);
    }

    @QueryMapping
    public List<Product> getProductsByCategory1(@Argument String category,
                                                @Argument int page,
                                                @Argument int size) {
        return productService.getAllProductsByCategory(category, page, size);
    }


    // Mutations

    @MutationMapping
    public Product addProduct(@Argument("input") ProductDto input) {
        return productService.addProduct(input);
    }

    @MutationMapping
    public Product updateProductStock(@Argument int productId, @Argument int quantity) {
        return productService.updateProductStock(productId, quantity);
    }

    @MutationMapping
    public Product updateNewShipment(@Argument int productId, @Argument int quantity) {
        return productService.updateNewShipment(productId, quantity);
    }
}
