package kz.aptekaplus.service;

import kz.aptekaplus.dto.product.ProductRequestDto;
import kz.aptekaplus.dto.product.ProductResponseDto;
import kz.aptekaplus.model.Product;

import java.util.List;

public interface ProductService extends CrudService<Product, ProductRequestDto, ProductResponseDto> {
    List<ProductResponseDto> getAllProducts();
}
