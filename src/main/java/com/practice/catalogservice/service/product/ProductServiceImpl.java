package com.practice.catalogservice.service.product;

import com.practice.catalogservice.utils.ProductUtils;
import com.practice.catalogservice.dto.product.ProductDTO;
import com.practice.catalogservice.dto.product.ProductInsert;
import com.practice.catalogservice.model.Product;
import com.practice.catalogservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public String insertProduct(ProductInsert product) {
        String uuid = UUID.randomUUID().toString();
        productRepository.insertProduct(uuid, product.getTitle(), product.getPrice());

        return uuid;
    }

    @Override
    public Collection<ProductDTO> getAllProducts() {
        Collection<Product> products = productRepository.getAllProduct();
        return ProductUtils.mapProducts(products);
    }

    @Override
    public ProductDTO getProductById(String productId) {
        Collection<Product> products = productRepository.getProductById(productId);

        return ProductUtils.mapProduct(products.stream().findFirst().get());
    }
}
