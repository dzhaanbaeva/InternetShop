package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Brands;
import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandsDTO {
    public static BrandsDTO from(Brands brands) {

        return builder()
                .id(brands.getId())
                .brand(brands.getBrand())
                .build();
    }


    @Id
    public int id;
    private String brand;



}
