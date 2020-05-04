package euphoria.kg.parfum.dto;

import euphoria.kg.parfum.model.Customer;
import lombok.*;

import java.util.UUID;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CustomerDTO {
    public static CustomerDTO from(Customer customer) {


        return builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .name(customer.getName())
                .build();
    }


    private int id;
    public String email;
    public String password;
    public String name;

}
