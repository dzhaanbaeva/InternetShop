package euphoria.kg.parfum.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String name;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String image;

    @NotBlank
    @Min(1)
    @PositiveOrZero
    @Column(length = 128)
    private int quantity;

    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String description;

    @Positive
    private float price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    @Positive
    private Brands brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    @Positive
    private Categories category;

}
