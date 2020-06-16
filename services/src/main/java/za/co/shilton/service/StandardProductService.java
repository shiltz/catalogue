package za.co.shilton.service;

import java.util.List;
import org.springframework.stereotype.Service;
import za.co.shilton.dto.ProductDto;
import za.co.shilton.entity.Product;

@Service("sps")
public class StandardProductService implements ProductService {

  public Product createProduct(ProductDto product) {
    Product product1 = new Product();
    product1.setName(product.getName());
    return product1;
  }

  @Override
  public List<ProductDto> getProducts() {
    return List.of(ProductDto.builder().name("asd").build());
  }

  public int doSomethingSimple(int a, int b) {
    return a + b ;
  }
}
