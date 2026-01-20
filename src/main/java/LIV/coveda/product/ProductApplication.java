package LIV.coveda.product;

import LIV.coveda.product.entities.Product;
import LIV.coveda.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ProductApplication {
	@Autowired
	private  ProductRepository productRepository;

	@PostConstruct
	public void initDB(){
		List<Product> products = Stream.of(
				new Product("Laptop","electronic","3423",35.565),
				new Product("Table","funiture","34233",35.565),
				new Product("Laptop","electronic","3423",35.565)
		).toList();
		productRepository.saveAll(products);

	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
