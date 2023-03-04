package com.example.tabletoplib.games;

import com.example.tabletoplib.users.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired private GameRepo repo;

    public List<Game> listAll(){
        return(List<Game>) repo.findAll();
    }


    public void save(Game game){
        repo.save(game);
    }

    public Game get(Integer id) throws GameNotFoundException{
        Optional<Game> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new GameNotFoundException("Game with id " + id + "not found");
    }

    public void delete(Integer id) throws GameNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new GameNotFoundException("Game with id " + id + "not found");
        }
        repo.deleteById(id);
    }

}
