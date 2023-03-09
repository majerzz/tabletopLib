package com.example.tabletoplib.mechanics;

import org.springframework.data.repository.CrudRepository;

public interface MechanicRepo extends CrudRepository<Mechanic, Integer> {
    public Long countById(Integer id);
}
