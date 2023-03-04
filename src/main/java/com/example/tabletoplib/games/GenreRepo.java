package com.example.tabletoplib.games;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre, Integer> {
    public Long countById(Integer id);
}
