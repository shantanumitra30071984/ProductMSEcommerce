package com.product.productms.service;

import com.product.productms.dto.ProductDto;
import com.product.productms.entity.Product;
import com.product.productms.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public Mono<ProductDto> saveProduct(ProductDto productDto) {
       /* try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Product productSaved = productRepository.save(product);
        ProductDto responseProduct = new ProductDto();
        responseProduct.setId(productSaved.getId());
        responseProduct.setName(productSaved.getName());
        responseProduct.setDescription(productSaved.getDescription());
        responseProduct.setPrice(productSaved.getPrice());
        return Mono.just(responseProduct);
    }
}
