package com.example.blog.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String userName;
    private String pass;
    private Integer phone;
    private String gmail;
    private String nation;

    @ManyToOne
    @JoinColumn(name = "rolesId", referencedColumnName = "id")
    private Roles roles;

    public User() {
    }

    public User(Integer id, String name, String userName, String pass, Integer phone, String gmail, String nation, Roles roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.phone = phone;
        this.gmail = gmail;
        this.nation = nation;
        this.roles = roles;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer number) {
        this.phone = number;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
