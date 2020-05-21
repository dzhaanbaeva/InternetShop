package euphoria.kg.parfum.repository;

import euphoria.kg.parfum.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart getByCustomerId(int id);
    Cart findCartBySession(String session);
}
