package ru.sbteducationplatform.entity;

import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by denis on 23/10/15.
 */
public class Subject {

    @Id
    private String id;
    private String name;
    private LinkedList<Post> posts = new LinkedList<>();

    public Subject(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(LinkedList<Post> posts) {
        this.posts = posts;
    }

    public Post addPost(Post post) {
        posts.addFirst(post);
        return post;
    }

}
