package euphoria.kg.parfum.service;

import euphoria.kg.parfum.dto.ProductsDTO;
import euphoria.kg.parfum.exception.ResourceNotFoundException;
import euphoria.kg.parfum.model.Products;
import euphoria.kg.parfum.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Products> selectProductsByName(String name) {
        return repo.getAllByNameLike(name);
    }
    public List<Products> selectProductsByDescription(String description) {
        return repo.getAllByDescriptionLike(description);
    }

    public Page<ProductsDTO> getProducts(Pageable pageable) {
        return repo.findAll(pageable)
                .map(ProductsDTO::from);
        //.toList();
    }
    public ProductsDTO getProduct(int id) {
        var place = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("place", id));
        return ProductsDTO.from(place);
    }
    public Page<ProductsDTO> getProd(int id, Pageable pageable) {
        return repo.findAllById(id, pageable)
                .map(ProductsDTO::from);
    }


}
