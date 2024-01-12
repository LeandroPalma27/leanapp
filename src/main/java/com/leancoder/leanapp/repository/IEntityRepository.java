package com.leancoder.leanapp.repository;

import java.util.List;

public interface IEntityRepository<T> {
    List<T> findAll();
    Boolean deleteById(long id);
}
