package euphoria.kg.parfum.service;

import euphoria.kg.parfum.dto.CustomerDTO;
import euphoria.kg.parfum.dto.CustomerRegistrationForm;
import euphoria.kg.parfum.exception.CustomerAlreadyRegisteredException;
import euphoria.kg.parfum.exception.CustomerNotFoundException;
import euphoria.kg.parfum.model.Customer;
import euphoria.kg.parfum.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    public CustomerDTO register(CustomerRegistrationForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var user = Customer.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return CustomerDTO.from(user);
    }

    public CustomerDTO getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerDTO.from(user);
    }
}
