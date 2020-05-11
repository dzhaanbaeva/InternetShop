package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Customer;
import lombok.*;


@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CustomerDTO {
    public static CustomerDTO from(Customer customer) {


        return builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .name(customer.getName())
                .build();
    }


    private int id;
    public String email;
    public String name;

}
