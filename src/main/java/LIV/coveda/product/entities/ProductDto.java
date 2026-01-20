package LIV.coveda.product.entities;

public record ProductDto(
        int id,
        String name,
        String category,
        Integer stock,
        double price
) {
}
