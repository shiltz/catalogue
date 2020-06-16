package za.co.shilton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.shilton.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

  Product findByName(String name);

}
