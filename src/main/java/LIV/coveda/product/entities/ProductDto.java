package LIV.coveda.product.entities;

public record ProductDto(
        int id,
        String name,
        String category,
        int stock,
        double price
) {
}
