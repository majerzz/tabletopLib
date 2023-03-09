package com.example.tabletoplib.genres;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Genre {

    public Genre() {
    }

    public Genre(Integer id) {
        this.id = id;
    }

    public Genre(String title) {
        this.title = title;
    }
    public Genre(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "genre_title", unique = false)
    private String title;

    @Column(name = "eng_genre_title", unique = true)
    private String engTitle;

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return title + "(" + engTitle + ")";
    }
}
