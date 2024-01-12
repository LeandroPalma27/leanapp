package com.leancoder.leanapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leancoder.leanapp.repository.IProductoRepository;
import com.leancoder.leanapp.repository.ProductoRepository;

@Configuration
public class BeansConfig {

    @Bean(name = "productoRepository2")
    IProductoRepository getProductoRepository() {
        return new ProductoRepository();
    }

}
