package LIV.coveda.product.service;


import LIV.coveda.product.entities.Product;
import LIV.coveda.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(String category) {
        return this.productRepository.findByCategory(category);
    }


}
