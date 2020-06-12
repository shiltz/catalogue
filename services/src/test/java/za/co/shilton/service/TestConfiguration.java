package za.co.shilton.service;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import za.co.shilton.repository.ProductRepository;

@Configuration
public class TestConfiguration {

  @MockBean
  protected ProductRepository productRepository;
}
