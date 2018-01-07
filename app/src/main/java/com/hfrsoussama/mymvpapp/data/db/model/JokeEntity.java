package com.hfrsoussama.mymvpapp.data.db.model;

import com.google.gson.annotations.Expose;
import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Oussama on 06/01/2018.
 */

@Entity(nameInDb = "joke")
public class JokeEntity {

    @Expose
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @Property(nameInDb = "content")
    private String content;

    @Generated(hash = 273526533)
    public JokeEntity(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Generated(hash = 674016985)
    public JokeEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static JokeEntity fromJoke(Joke joke) {
        return new JokeEntity(joke.getId(), joke.getContent());
    }
}
