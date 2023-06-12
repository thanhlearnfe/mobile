package com.example.myapplication.love;

public class LoveData {
    public int id;
    public int resourceImage;
    public String name;

    public LoveData(int id, int resourceImage, String name) {
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

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
