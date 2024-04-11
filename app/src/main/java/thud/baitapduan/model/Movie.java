package thud.baitapduan.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String description;
    private int image;
    private String director;
    private String cast;
    private int duration;

    public Movie() {
    }

    public Movie(String title, String description, int image, String director, String cast, int duration) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.director = director;
        this.cast = cast;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
