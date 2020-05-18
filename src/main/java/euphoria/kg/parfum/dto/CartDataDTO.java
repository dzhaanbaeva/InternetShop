package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.CartsData;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartDataDTO {
    public static CartDataDTO from(CartsData cartsData){
        return builder()
                .id(cartsData.getId())
                .product(cartsData.getProduct().getId())
                .cart(cartsData.getCarts().getId())
                .qty(cartsData.getQty())
                .build();

    }

     private int id;
     private Integer product;
     private Integer cart;
     private int qty;

  }
