package euphoria.kg.parfum.service;

import euphoria.kg.parfum.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private  final ProductsRepository productsRepository;

    public void addProduct(Integer productId) {
//        var product = productsRepository.findById(productId);
//        System.out.println(product + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++HERE");
    }

}
