package LIV.coveda.product.service;


import LIV.coveda.product.entities.Product;
import LIV.coveda.product.entities.ProductDto;
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
    public Product updateProductStock (int productId, int quantity) {
        Product existingProduct = productRepository.findById((long) productId)
                .orElseThrow(()-> new RuntimeException("product with "+productId+"not found"));
        existingProduct.setStock(existingProduct.getStock()-quantity);
        return productRepository.save(existingProduct);

    }

    public Product updateNewShipment (int productId, int quantity) {
        Product existingProduct = productRepository.findById((long) productId)
                .orElseThrow(()-> new RuntimeException("product with "+productId+"not found"));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepository.save(existingProduct);

    }

    public Product addProduct(ProductDto input) {
        Product product = new Product(
                (long) input.id(),
                input.name(),
                input.category(),
                input.stock(),
                input.price()
        );

        return productRepository.save(product);
    }




}
