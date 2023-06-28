package com.example.myapplication.filmlist;

import java.util.Objects;

public class Film {
    public int id;
    public String resourceImage;
    public String name;

    public Film(int id, String resourceImage, String name) {
        this.id = id;
        this.resourceImage = resourceImage;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return getId() == film.getId() && getResourceImage().equals(film.getResourceImage()) && getName().equals(film.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getResourceImage(), getName());
    }
}
