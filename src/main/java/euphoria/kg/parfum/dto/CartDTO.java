package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Cart;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartDTO {
    public static CartDTO from(Cart cart){
        return builder()
                .id(cart.getId())
                .customerId(cart.getCustomer().getId())
                .build();

    }

    public int id;
     public Integer customerId;
  }
