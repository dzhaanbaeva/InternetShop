package euphoria.kg.parfum.model;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "carts_data")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CartsData {

    @Id
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products product;

    @ManyToOne
    @JoinColumn(name = "carts_id")
    Cart carts;

    Integer qty = 1;

    public CartsData(Products product, Cart carts, Integer qty) {
        this.product = product;
        this.carts = carts;
        this.qty = qty;
    }
}
