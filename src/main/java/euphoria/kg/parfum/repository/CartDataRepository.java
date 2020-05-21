package euphoria.kg.parfum.repository;

import euphoria.kg.parfum.model.Cart;
import euphoria.kg.parfum.model.CartsData;
import euphoria.kg.parfum.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartDataRepository extends JpaRepository<CartsData, Integer> {
    CartsData findCartsDataByProductAndCarts(Products products, Cart cart);
}
