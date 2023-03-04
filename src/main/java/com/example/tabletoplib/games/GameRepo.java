package com.example.tabletoplib.games;

import org.springframework.data.repository.CrudRepository;

public interface GameRepo extends CrudRepository<Game, Integer> {
    public Long countById(Integer id);
}
