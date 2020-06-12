package za.co.shilton.service;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import za.co.shilton.repository.ProductRepository;

public class MockConfiguration {

  @Bean
  public StandardProductService getProductSerive(){
    return new StandardProductService();
  }

  @Bean
  public ComplexProductService getComplexService(){
    return new ComplexProductService();
  }



}
