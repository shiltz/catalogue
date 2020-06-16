package integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.shilton.entity.Product;
import za.co.shilton.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration (classes = IntegrationTestConfig.class)
public class ProductRepositoryTest {


  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void when_findByName_is_called_it_find_the_correct_product() {
    Product product = new Product();
    product.setName("haibo");

    testEntityManager.persistAndFlush(product);

    Product newProduct = productRepository.findByName("haibo");
    assertEquals("haibo", newProduct.getName());
  }

  @AfterEach
  public void cleanup() {
    productRepository.deleteAll();
  }

}
