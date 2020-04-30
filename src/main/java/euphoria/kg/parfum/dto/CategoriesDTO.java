package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Categories;
import lombok.*;


@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class CategoriesDTO {

    public int id;
    private String category;

    public static CategoriesDTO from(Categories categories) {

        return builder()
                .id(categories.getId())
                .category(categories.getCategory())
                .build();
    }


    public void build() {
    }
}
