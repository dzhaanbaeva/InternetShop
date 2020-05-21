package euphoria.kg.parfum.controller;

import euphoria.kg.parfum.dto.CustomerRegistrationForm;
import euphoria.kg.parfum.model.Customer;
import euphoria.kg.parfum.model.PasswordResetToken;
import euphoria.kg.parfum.repository.CustomerRepository;
import euphoria.kg.parfum.repository.ResetRepository;
import euphoria.kg.parfum.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


import java.security.Principal;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository repository;
    private final ResetRepository resetRepo;

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }


    @GetMapping("/register")
    public String pageRegistrationCustomer(Model model) {
        if(!model.containsAttribute("form")){
            model.addAttribute("form", new CustomerRegistrationForm());
        }

        return "register";
    }
//
//    @GetMapping("/test")
//    @ResponseBody
//    public  String getTestPage(@Valid CustomerRegistrationForm form){
//        return form.getEmail();
//    }

    @PostMapping("/register")
    public String registerPage(@Valid CustomerRegistrationForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String pageForgotPassword(Model model) {
        return "forgot";
    }


    @PostMapping("/forgot-password")
    public String submitForgotPasswordPage(@RequestParam("email") String email,
                                           RedirectAttributes attributes) {

        if (!repository.existsByEmail(email)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/";
        }

        PasswordResetToken pToken = PasswordResetToken.builder()
                .customer(repository.findByEmail(email).get())
                .token(UUID.randomUUID().toString())
                .build();

        resetRepo.deleteAll();
        resetRepo.save(pToken);

        return "redirect:/forgot-success";
    }

    @GetMapping("/forgot-success")
    public String pageResetPassword(Model model) {
        return "forgot-success";
    }

    @PostMapping("/reset-password")
    public String submitResetPasswordPage(@RequestParam("token") String token,
                                          @RequestParam("newPassword") String newPassword,
                                          RedirectAttributes attributes) {

        if (!resetRepo.existsByToken(token)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/reset-password";
        }

        PasswordResetToken pToken = resetRepo.findByToken(token).get();
        Customer customer = repository.findById(pToken.getCustomer().getId()).get();
        customer.setPassword(new BCryptPasswordEncoder().encode(newPassword));

        repository.save(customer);

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }


    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex){
        var apiFieldErrors=ex.getFieldErrors()
                .stream()
                .map(fe->String.format("%s ->%s",fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }
}
