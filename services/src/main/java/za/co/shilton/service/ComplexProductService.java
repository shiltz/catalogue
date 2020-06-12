package za.co.shilton.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.shilton.dto.ProductDto;
import za.co.shilton.entity.Product;
import za.co.shilton.repository.ProductRepository;

@Service
public class ComplexProductService implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product createProduct(ProductDto product) {
    Product product1 = new Product();
    product1.setName("Shilo Prod");
    return productRepository.save(product1);
  }

  @Override
  public List<ProductDto> getProducts() {
    return List.of(new ProductDto());
  }

}
