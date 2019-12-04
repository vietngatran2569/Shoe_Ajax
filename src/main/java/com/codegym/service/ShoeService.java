package com.codegym.service;

import com.codegym.model.Shoe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShoeService {
    Page<Shoe> findAll(Pageable pageable);
    Shoe findById(Integer id);
    Shoe save(Shoe shoe);
    Shoe remove(Integer id);

    Page<Shoe> findAllByNameContaining(String name, Pageable pageable);

}
