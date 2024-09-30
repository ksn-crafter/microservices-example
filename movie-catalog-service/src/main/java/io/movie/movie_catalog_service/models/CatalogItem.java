package io.movie.movie_catalog_service.models;

public class CatalogItem {
    private String name;
    private String desc;
    private float rating;

    public CatalogItem(String name, String desc, float rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
