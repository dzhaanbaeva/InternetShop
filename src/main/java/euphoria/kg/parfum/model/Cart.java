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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


//    public Cart(String session) {
//        this.session = session;
//    }

    public List<CartsData> getProducts() {
        return new ArrayList<>();
    }
}
