package com.shree.ecommerce.service.impl;

import com.shree.ecommerce.entity.Category;
import com.shree.ecommerce.entity.Product;
import com.shree.ecommerce.exception.CategoryNotFoundException;
import com.shree.ecommerce.exception.ProductNotFoundException;
import com.shree.ecommerce.repository.CategoryRepository;
import com.shree.ecommerce.repository.ProductRepository;
import com.shree.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {

        Long categoryId = product.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found with id: " + categoryId));

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));

        Long categoryId = product.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found with id: " + categoryId));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setCategory(category);

        return productRepository.save(existingProduct);
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }

    @Override
    public List<Product> searchByName(String name) {

        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> searchByBrand(String brand) {

        return productRepository.findByBrandIgnoreCase(brand);
    }

    @Override
    public List<Product> searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {

        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {

        return productRepository.findByCategoryId(categoryId);
    }
}