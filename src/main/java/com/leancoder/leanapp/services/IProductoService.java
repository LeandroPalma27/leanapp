package com.leancoder.leanapp.services;

import java.util.List;

import com.leancoder.leanapp.model.Producto;

public interface IProductoService extends IEntityService<Producto>{

    @Override
    List<Producto> findAllRecords();
}
