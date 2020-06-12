package za.co.shilton.service;

import java.util.List;
import org.springframework.stereotype.Service;
import za.co.shilton.dto.ProductDto;
import za.co.shilton.entity.Product;

@Service("sps")
public class StandardProductService implements ProductService {

  @Override
  public Product createProduct(ProductDto product) {
    Product product1 = new Product();
    product1.setName("Shilo Prod");
    return product1;
  }

  @Override
  public List<ProductDto> getProducts() {
    return List.of(new ProductDto());
  }

  public int doSomethingSimple(int a, int b) {
    return a + b ;
  }
}
