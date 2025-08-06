package com.product.productms.controller;

import com.product.productms.dto.ProductDto;
import com.product.productms.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        Mono<Object> objectMono = serverRequest.bodyToMono(ProductDto.class).flatMap(productDto -> {
            System.out.println(productDto.getName());
            return productService.saveProduct(productDto);
        });
        return ServerResponse.ok().body(objectMono, ProductDto.class);
    }
}
