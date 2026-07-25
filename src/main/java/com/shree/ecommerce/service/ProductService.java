package com.shree.ecommerce.service;

import com.shree.ecommerce.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    List<Product> searchByName(String name);

    List<Product> searchByBrand(String brand);

    List<Product> searchByPriceRange(BigDecimal minPrice,
                                     BigDecimal maxPrice);

    List<Product> getProductsByCategory(Long categoryId);
}