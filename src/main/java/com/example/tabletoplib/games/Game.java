package com.example.tabletoplib.games;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbgames")
public class Game {

    public Game(){}

    public Game(String title, Integer minAm, Integer maxAm, Integer averagePlayTime) {
        this.title = title;
        this.minAm = minAm;
        this.maxAm = maxAm;
        this.averagePlayTime = averagePlayTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "GameTitle")
    private String title;

    @Column(name = "min_am_of_players")
    private Integer minAm;

    @Column(name = "max_am_of_players")
    private Integer maxAm;

    @Column(name = "average_play_time")
    private Integer averagePlayTime;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbgames_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    public void deleteGenre(Genre genre){
        this.genres.remove(genre);
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
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

    public Integer getMinAm() {
        return minAm;
    }

    public void setMinAm(Integer minAm) {
        this.minAm = minAm;
    }

    public Integer getMaxAm() {
        return maxAm;
    }

    public void setMaxAm(Integer maxAm) {
        this.maxAm = maxAm;
    }

    public Integer getAveragePlayTime() {
        return averagePlayTime;
    }

    public void setAveragePlayTime(Integer averagePlayTime) {
        this.averagePlayTime = averagePlayTime;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", minAm=" + minAm +
                ", maxAm=" + maxAm +
                ", averagePlayTime=" + averagePlayTime +
                ", genres=" + genres +
                '}';
    }
}
