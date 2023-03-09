package com.example.tabletoplib.mechanics;


import com.example.tabletoplib.genres.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Mechanic {

    public Mechanic(){}

    public Mechanic(Integer id) {
        this.id = id;
    }

    public Mechanic(String title) {
        this.title = title;
    }

    public Mechanic(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Mechanic(String title, String engTitle) {
        this.title = title;
        this.engTitle = engTitle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mechanic_title", unique = false)
    private String title;

    @Column(name="eng_mechanic_title", unique = true)
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
        Mechanic mechanic = (Mechanic) o;
        return id.equals(mechanic.id);
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

