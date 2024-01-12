package com.leancoder.leanapp.repository;

import java.util.List;

import com.leancoder.leanapp.model.Producto;

public interface IProductoRepository extends IEntityRepository<Producto>{

    @Override
    Boolean deleteById(long id);

    @Override
    List<Producto> findAll();
    
}
