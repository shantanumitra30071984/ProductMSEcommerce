package com.product.productms.config;

import com.product.productms.controller.ProductController;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class ProductConfig {
    ProductController productController;
    @Bean
    RouterFunction<ServerResponse> productRouterDunction() {


        return RouterFunctions.route(RequestPredicates.POST("/create/product"),productController::createProduct);
    }
}
