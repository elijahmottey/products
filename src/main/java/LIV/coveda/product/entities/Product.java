package LIV.coveda.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String stock;
    private Double price;

    public Product(String name, String category, String stock, Double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }
}
