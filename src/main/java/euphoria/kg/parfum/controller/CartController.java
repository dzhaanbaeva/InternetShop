package euphoria.kg.parfum.controller;

import euphoria.kg.parfum.BasketDTO;
import euphoria.kg.parfum.model.Cart;
import euphoria.kg.parfum.model.CartsData;
import euphoria.kg.parfum.repository.CartDataRepository;
import euphoria.kg.parfum.repository.CartRepository;
import euphoria.kg.parfum.repository.CustomerRepository;
import euphoria.kg.parfum.repository.ProductsRepository;
import euphoria.kg.parfum.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class CartController {
    private final CartRepository cartRepo;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final CartDataRepository cartDataRepository;
    private final ProductsRepository productsRepository;

    public CartController(CartRepository cartRepo, CustomerService customerService, CustomerRepository customerRepository, CartDataRepository cartDataRepository, ProductsRepository productsRepository) {
        this.cartRepo = cartRepo;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.cartDataRepository = cartDataRepository;
        this.productsRepository = productsRepository;
    }

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constants.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            model.addAttribute("cartItems", cart);
        }
        return "cart";
    }


    @PostMapping(value = "/cart/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void addToCart(@RequestBody BasketDTO basketGivenDTO, Principal principal) {
        var customer = customerService.getByEmail(principal.getName());
                       cartRepo.save(Cart.builder()
                .customer(customerRepository.getById(customer.getId()))
                .build()
        );
               cartDataRepository.save(CartsData.builder()
                        .carts(cartRepo.getByCustomerId(customer.getId()))
                        .product(productsRepository.getProductsById(Integer.parseInt(basketGivenDTO.getProduct_id())))
                        .build()
        );

    }

//    @PostMapping("/cart/add")
//    public Products addCart(@RequestParam(value = "id", required = false) Integer id, HttpSession session){
//        var product = productsRepository.findProductById(id);
//        Cart cart = cartRepo.findBasketBySession(session.getId());
//        if(cartDataRepository.findCartsDataByProductAndCarts(product,cart)==null){
//            CartsData cartProduct = new CartsData(product, cart,1);
//            cartDataRepository.save(cartProduct);
//        } else {
//            CartsData cartProduct = cartDataRepository.findCartsDataByProductAndCarts(product, cart);
//            cartDataRepository.delete(cartProduct);
//        }
//        return product;
//    }



    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.CART_ID);

        return "redirect:/cart";
    }
}

