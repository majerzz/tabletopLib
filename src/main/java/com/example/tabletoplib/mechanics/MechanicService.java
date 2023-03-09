package com.example.tabletoplib.mechanics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicService {
    @Autowired private MechanicRepo repo;
    @Autowired private MechanicSortingRepo sortRepo;

    public void save(Mechanic mechanic){
        repo.save(mechanic);
    }

    public Mechanic get(Integer id) throws MechanicNotFoundException{
        Optional<Mechanic> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new MechanicNotFoundException("Mechanic with id " + id + "not found");
    }

    public void delete(Integer id) throws MechanicNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new MechanicNotFoundException("Mechanic with id " + id + "not found");
        }
        repo.deleteById(id);
    }

    public List<Mechanic> listAll(){
        return (List<Mechanic>)repo.findAll();
    }

    public List<Mechanic> listAllSorted(){
        List<Mechanic> list = (List<Mechanic>)sortRepo.findAll(Sort.by(Sort.Direction.ASC, "engTitle"));
        return list;
    }
}
