package com.example.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String img;
    @NotBlank
    private String title;
    @NotBlank
    @Size(min = 10, max = 100)
    private String des;//mô tả
    @Size(min = 100, max = 10000)
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @NotEmpty
    private LocalDate date;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public Blog() {
    }

    public Blog(Integer id, String img, String title, String des, String content, LocalDate date, User user, Category category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.des = des;
        this.content = content;
        this.date = date;
        this.user = user;
        this.category = category;
    }
}
