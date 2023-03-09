package com.example.tabletoplib.genres;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre, Integer> {
    public Long countById(Integer id);

}
