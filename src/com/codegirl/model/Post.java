package com.codegirl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Şeyma Yılmaz on 2.8.2017.
 */
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private  String title;
    private  String content;

    @OneToOne
    @JoinColumn(name = "postDetails_ID")
    private PostDetails postDetails;

    @OneToMany(mappedBy = "post")
    /*
    @JoinTable(
            name = "postcomment",
            joinColumns = @JoinColumn(name = "post_ID"),
            inverseJoinColumns = @JoinColumn(name = "comment_ID")
    )*/
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
