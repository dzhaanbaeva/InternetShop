package euphoria.kg.parfum.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String email;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String password;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String name;

}
