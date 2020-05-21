package euphoria.kg.parfum.model;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Data
@Table(name = "carts_data")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CartsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

    @ManyToOne
    @JoinColumn(name = "carts_id")
    private Cart carts;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;



    private Integer qty = 1;

    public CartsData(Cart carts,Products product,  Integer qty) {
        this.carts = carts;
        this.product = product;
        this.qty = qty;
    }

    public CartsData(Cart cart, Optional<Products> product, int qty) {
    }
}
