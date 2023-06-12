package com.example.myapplication.love;

import com.example.myapplication.filmlist.Film;


import java.util.ArrayList;


public class Love extends Film {
    private static ArrayList<Film> loveData = new ArrayList<>();

    public Love(int id, int resourceImage, String name) {
        super(id, resourceImage, name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static void setLoveData(ArrayList<Film> loveData) {
        Love.loveData= loveData;
    }
    public static void addFilm(Film u){
        loveData.add(u);
    }




}
