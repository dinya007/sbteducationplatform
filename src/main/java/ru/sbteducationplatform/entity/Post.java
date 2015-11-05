package ru.sbteducationplatform.entity;

import org.springframework.data.annotation.Id;

public class Post {

    @Id
    private String id;
    private String author;
    private String message;
    private String title;
    private byte[] attachment;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    private Post() {
    }

    public Post(String author) {
        this.author = author;
    }

    public Post(String author, String message) {
        this.author = author;
        this.message = message;
    }
}
