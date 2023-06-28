package com.example.myapplication.love;

import androidx.annotation.Nullable;

import com.example.myapplication.filmlist.Film;


import java.util.ArrayList;
import java.util.Objects;


public class Love extends Film {
    private static ArrayList<Film> loveData = new ArrayList<>();

    public Love(int id, String resourceImage, String name) {
        super(id, resourceImage, name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static ArrayList<Film> getLoveData() {
        return loveData;
    }
    public static void addFilm(Film u){
        if (!loveData.contains(u)) {
            loveData.add(u);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceImage, name);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Love other = (Love) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(resourceImage, other.resourceImage)
                && Objects.equals(name, other.name);
    }
}
