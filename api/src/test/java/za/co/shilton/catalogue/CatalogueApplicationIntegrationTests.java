package za.co.shilton.catalogue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import za.co.shilton.entity.Product;
import za.co.shilton.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CatalogueApplication.class)
@TestPropertySource(
    locations = "classpath:application.properties")
@AutoConfigureMockMvc
@Tag("integration")
class CatalogueApplicationIntegrationTests {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void when_create_product_is_called_it_should_return_correct_product() throws Exception {
    assertAll("heading",
        () -> {
          mvc.perform(post("/api/product")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(content()
                  .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
              .andDo(MockMvcResultHandlers.print())
              .andExpect(jsonPath("$.name").value("haibo"));
        },
        () -> {
          Product newProduct = productRepository.findByName("haibo");
          assertEquals("haibo", newProduct.getName());
        });
  }

  @AfterEach
  public void cleanup() {
    productRepository.deleteAll();
  }

}
