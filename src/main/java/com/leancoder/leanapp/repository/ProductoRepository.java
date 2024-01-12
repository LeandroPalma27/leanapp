package com.leancoder.leanapp.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.leancoder.leanapp.model.Producto;

@Repository(value = "productoRepository")
@RequestScope
public class ProductoRepository implements IProductoRepository{

    private List<Producto> products;

    public ProductoRepository() {
        this.products = Arrays.asList(new Producto(1L, "laptop gamer", 2000L), new Producto(2L, "PC gamer", 1500L),
                new Producto(3L, "PS5", 2500L));
    }

    @Override
    public List<Producto> findAll() {
        return this.products;
    }

    @Override
    public Boolean deleteById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
