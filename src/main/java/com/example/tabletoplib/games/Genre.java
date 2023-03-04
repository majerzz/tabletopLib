package com.example.tabletoplib.games;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Genre {

    public Genre() {
    }

    public Genre(Integer id) {
        this.id = id;
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre(Integer id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "genre", unique = true)
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id.equals(genre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return genre;
    }
}
