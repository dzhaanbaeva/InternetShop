package euphoria.kg.parfum.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128)
    private String category;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @OrderBy("category ASC")
    List<Products> products;
}
