package com.example.myapplication.filmlist;

import java.util.ArrayList;

public class FilmRepository {
    private static ArrayList<Film> filmList = new ArrayList<>();

    public FilmRepository(ArrayList<Film> lst) {
        for (Film p: lst){
            this.filmList.add(p);
        }
    }
    public FilmRepository(){

    }

    public static ArrayList<Film> getFilmList() {
        return filmList;
    }

    public static void setFilmList(ArrayList<Film> filmList) {
        FilmRepository.filmList = filmList;
    }

    public void addFilm(Film p){
        this.filmList.add(p);
    }

    public Film getFilm(Integer id){
        Film result;
        for ( Film p : filmList) {
            if (id == p.getId())
                return p;
        }
        return  null;
    }
}
