package euphoria.kg.parfum.service;

import euphoria.kg.parfum.model.Products;
import euphoria.kg.parfum.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private final ProductsRepository repo;

    public ProductsService(ProductsRepository repo) {
        this.repo = repo;
    }

    public Iterable<Products> getProducts() {
        return repo.findAll();
    }

    public Iterable<Products> getProductsName(String name) {
        return repo.getByName(name);
    }
}
