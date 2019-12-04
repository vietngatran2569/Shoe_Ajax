package com.codegym.service;

import com.codegym.model.Shoe;
import com.codegym.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ShoeServiceImpl implements ShoeService{

    @Autowired
    ShoeRepository shoeRepository;

    @Override
    public Page<Shoe> findAll(Pageable pageable) {
        return shoeRepository.findAll(pageable);
    }

    @Override
    public Shoe findById(Integer id) {
        return shoeRepository.findById(id).get();
    }

    @Override
    public Shoe save(Shoe shoe) {
         return shoeRepository.save(shoe);
    }

    @Override
    public Shoe remove(Integer id) {
       Shoe shoe=findById(id);
       shoeRepository.deleteById(id);
       return shoe;
    }

    @Override
    public Page<Shoe> findAllByNameContaining(String name, Pageable pageable) {
        return shoeRepository.findAllByNameContaining(name,pageable);
    }
}
