package za.co.shilton.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.*;
import za.co.shilton.dto.ProductDto;
import za.co.shilton.service.ProductService;

import javax.sql.DataSource;
import java.util.List;
import za.co.shilton.service.StandardProductService;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.shilton"})
@EnableJpaRepositories(basePackages = { "za.co.shilton.repository" })
@EntityScan("za.co.shilton.entity")
public class CatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUsername("mysqluser");
//		dataSource.setPassword("mysqlpass");
//		dataSource.setUrl(
//				"jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");
//
//		return dataSource;
//	}


	@RestController
	@RequestMapping("/api/product")
	public class ProductController {

		@Autowired
		@Qualifier("sps")
		private ProductService productService;

		@GetMapping
		public ResponseEntity<List<ProductDto>> getProducts() {
			return ResponseEntity.ok(productService.getProducts());
		}


		@PostMapping
		public ResponseEntity createProduct() {
			productService.createProduct(null);
			return ResponseEntity.accepted().build();
		}

	}

}
