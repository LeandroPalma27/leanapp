package com.leancoder.leanapp.services;

import java.util.List;

public interface IEntityService<T> {
    
    List<T> findAllRecords();

}
