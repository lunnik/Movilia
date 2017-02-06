package com.lionsquare.movilia.model;

/**
 * Created by edgararana on 06/02/17.
 */

public class Celulares {

    String title;
    String urlImage;

    public Celulares(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
