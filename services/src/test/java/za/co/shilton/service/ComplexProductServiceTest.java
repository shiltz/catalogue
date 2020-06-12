package za.co.shilton.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.shilton.dto.ProductDto;
import za.co.shilton.entity.Product;
import za.co.shilton.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@Import(MockConfiguration.class)
class ComplexProductServiceTest extends TestConfiguration {

  @Autowired
  private ComplexProductService complexProductService;

  @BeforeEach
  public void setup() {
    when(productRepository.save(any(Product.class))).thenReturn(new Product());
  }

  @Test
  public void testCreateProduct() {
    ProductDto productDto = new ProductDto();
    productDto.setName("test");
    Product product = complexProductService.createProduct(productDto);

    verify(productRepository, times(1)).save(any(Product.class)); // most important
    assertNotNull(product);
  }
}