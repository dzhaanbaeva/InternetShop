package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Products;
import lombok.*;


@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsDTO {
    public static ProductsDTO from(Products products){
        return builder()
                .id(products.getId())
                .name(products.getName())
                .image(products.getImage())
                .imagePath(calcStoreImagePath(products))
                .quantity(products.getQuantity())
                .description(products.getDescription())
                .price(products.getPrice())
                .brand(BrandsDTO.from(products.getBrand()))
                .category(CategoriesDTO.from(products.getCategory()))
                .build();

    }

    private Integer id;
    private String name;
    private String image;
    private String imagePath;
    private int quantity;
    private String description;
    private float price;
    private BrandsDTO brand;
    private CategoriesDTO category;

    private static String calcStoreImagePath(Products product) {
        if (!product.getImage().isBlank()) {
            return product.getImage();
        }
        return String.format("/images/%s", product.getName());
    }
}
