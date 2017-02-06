package com.lionsquare.movilia.model;

/**
 * Created by edgararana on 06/02/17.
 */

public class Menu {
    String title;
    int image;

    public Menu(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
