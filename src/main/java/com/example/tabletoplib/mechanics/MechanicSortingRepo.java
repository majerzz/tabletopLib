package com.example.tabletoplib.mechanics;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MechanicSortingRepo extends PagingAndSortingRepository<Mechanic, Integer> {

    List<Mechanic> findAll();
    List<Mechanic> findByEngTitle(String engTitle);
}