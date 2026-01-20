package LIV.coveda.product.repository;

import LIV.coveda.product.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // Non-paginated
    List<Product> findByCategory(String category);

    // Paginated
    Page<Product> findByCategory(String category, Pageable pageable);
}
