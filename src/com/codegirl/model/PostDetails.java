package com.codegirl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Şeyma Yılmaz on 2.8.2017.
 */
@Entity
public class PostDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String createdBy;
    private Date date;
    private String location;

    @OneToOne(mappedBy = "postDetails")
    private Post post;

    public PostDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
