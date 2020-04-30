package euphoria.kg.parfum.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128)
    private String brand;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    @OrderBy("brand ASC")
    List<Products> products;
}
