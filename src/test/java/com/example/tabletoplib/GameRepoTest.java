package com.example.tabletoplib;

import com.example.tabletoplib.games.Game;
import com.example.tabletoplib.games.GameRepo;
import com.example.tabletoplib.genres.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class GameRepoTest {
    @Autowired
    private GameRepo repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateGenres(){
        Genre areaControl = new Genre("Контроль территорий");

        entityManager.persist(areaControl);
    }

    @Test
    public void testCreateNewGameWithOneGenre(){
        Genre economic = entityManager.find(Genre.class, 1);
        Game game = new Game("Серп", 1, 5, 110);
        game.addGenre(economic);

        repo.save(game);
    }

    @Test
    public void testCreateNewGameWithTwoGenres(){
        Genre economic = entityManager.find(Genre.class, 1);
        Genre fighting = entityManager.find(Genre.class, 2);
        Game game = new Game("Серп", 1, 5, 110);

        game.addGenre(economic);
        game.addGenre(fighting);

        repo.save(game);
    }

    @Test
    public void testAddGenreToExistingGame(){
        Game game = repo.findById(8).get();
        Genre scienceFiction = entityManager.find(Genre.class, 3);
        game.addGenre(scienceFiction);
    }

    @Test
    public void testRemoveGenreFromExistingGame(){
        Game game = repo.findById(8).get();
        Genre genre = new Genre(3);
        game.deleteGenre(genre);
    }
}
