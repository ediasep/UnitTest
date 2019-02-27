package com.mitrais.asep.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name="title")
    private String title;

    @Column(name="isbn")
    private String isbn;

    @Column(name="author")
    private String author;

    @Column(name="status")
    private String status; // Shelved, Not Shelved

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book(String title, String isbn, String author, String status) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.status = status;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book Details?= Id: " + this.Id + ", Title: " + this.title + ", ISBN: " + this.isbn + ", Author: " + this.author + ", Status: " + this.status;
    }
}
