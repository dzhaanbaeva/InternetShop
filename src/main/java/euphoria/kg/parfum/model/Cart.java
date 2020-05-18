package euphoria.kg.parfum.model;

import lombok.*;
import org.springframework.boot.web.servlet.server.Session;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    private String session;

    @OneToMany(mappedBy = "carts")
    List<CartsData> cartData;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    @Positive
    private Customer customer;


    public Cart(Customer customer, String session) {
        this.customer = customer;
        this.session = session;
    }

    public List<CartsData> getProducts() {
        return new ArrayList<>();
    }
}
