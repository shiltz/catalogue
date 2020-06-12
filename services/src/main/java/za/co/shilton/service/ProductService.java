package za.co.shilton.service;

import za.co.shilton.dto.ProductDto;

import java.util.List;
import za.co.shilton.entity.Product;

public interface ProductService {

    Product createProduct(ProductDto product);

    List<ProductDto> getProducts();
}
