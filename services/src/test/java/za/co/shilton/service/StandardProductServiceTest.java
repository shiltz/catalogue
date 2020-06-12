package za.co.shilton.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Import(MockConfiguration.class)
@ExtendWith(SpringExtension.class)
class StandardProductServiceTest extends TestConfiguration{

  @Autowired
  private StandardProductService standardProductService;

  @Test
    void doSomethingSimple_withInput1And1_shouldReturn2() {
    assertEquals(2, standardProductService.doSomethingSimple(1,1));
  }

}