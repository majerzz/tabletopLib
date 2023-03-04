package com.example.tabletoplib.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired private GenreRepo repo;

    public void save(Genre genre){
        repo.save(genre);
    }

    public Genre get(Integer id) throws GenreNotFoundException{
        Optional<Genre> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new GenreNotFoundException("Genre with id " + id + "not found");
    }

    public void delete(Integer id) throws GenreNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new GenreNotFoundException("Genre with id " + id + "not found");
        }
        repo.deleteById(id);
    }

    public List<Genre> listAll(){
        return(List<Genre>) repo.findAll();
    }

    public List<Genre> listAllSorted(){
        List<Genre> list = (List<Genre>)repo.findAll();
        list.sort(Comparator.comparing(Genre::getGenre));
        return list;
    }
}
