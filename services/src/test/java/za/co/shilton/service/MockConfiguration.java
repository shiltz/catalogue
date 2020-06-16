package za.co.shilton.service;

import org.springframework.context.annotation.Bean;

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
