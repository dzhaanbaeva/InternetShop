package euphoria.kg.parfum.repository;


import euphoria.kg.parfum.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query("select p from Products as p where p.name like CONCAT(:name, '%')")
    public List<Products> getByName(String name);

    Page<Products> findAllById(int Id, Pageable pageable);

//    @Query("select p from Products as p where p.name and p.description like  CONCAT(:name, description, '%,%')")
    public List<Products> getAllByNameLike(String name);
    public List<Products> getAllByDescriptionLike(String description);


}
