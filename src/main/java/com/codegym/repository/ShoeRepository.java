package com.codegym.repository;

import com.codegym.model.Shoe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShoeRepository extends PagingAndSortingRepository<Shoe,Integer> {
    Page<Shoe> findAllByNameContaining(String name, Pageable pageable);

}
