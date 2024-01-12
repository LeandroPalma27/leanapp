package com.leancoder.leanapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.leancoder.leanapp.model.Producto;
import com.leancoder.leanapp.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;
    @Value("${values.iva}")
    private String IVA;

    @Override
    public List<Producto> findAllRecords() {
        return productoRepository.findAll().stream().map(product -> {
            var newPrice = product.getPrice() * Double.parseDouble(IVA);
            /* Producto newProd = (Producto) product.clone();
            newProd.setPrice(newPrice); */
            product.setPrice(newPrice);
            return product;
        }).toList();
    }

}
