package com.example.tabletoplib.genres;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GenreSortingRepo extends PagingAndSortingRepository<Genre, Integer> {

    List<Genre> findAll();
}