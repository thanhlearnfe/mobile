package com.example.myapplication.filmlist;

import java.util.Objects;

public class Film {
    public int id;
    public String resourceImage;
    public String name;
    public String resourceVideo;

    public Film(int id, String resourceImage, String name, String resourceVideo) {
        this.id = id;
        this.resourceImage = resourceImage;
        this.name = name;
        this.resourceVideo = resourceVideo;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceVideo() {
        return resourceVideo;
    }

    public void setResourceVideo(String resourceVideo) {
        this.resourceVideo = resourceVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return getId() == film.getId() && Objects.equals(getResourceImage(), film.getResourceImage()) && Objects.equals(getName(), film.getName()) && Objects.equals(getResourceVideo(), film.getResourceVideo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getResourceImage(), getName(), getResourceVideo());
    }
}
