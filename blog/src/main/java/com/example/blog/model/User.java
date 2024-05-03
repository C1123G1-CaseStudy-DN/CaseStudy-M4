package com.example.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    @NotBlank(message = "Password is required") // Mật khẩu không được để trống
    @Pattern(
            regexp = "^(?=.*[A-Z])[A-Za-z0-9]{6,}$", // Phải có ít nhất một chữ hoa và không có ký tự đặc biệt
            message = "Password must contain at least one uppercase letter and no special characters"
    )
    private String pass;
    @Pattern(regexp = "\\d{10,11}", message = "Phone must be 10-11 digits")
    private String phone;
    @Email(message = "Email should be valid")
    private String gmail;
    private String nation;

    @ManyToOne
    @JoinColumn(name = "rolesId", referencedColumnName = "id")
    private Roles roles;

    public User() {
    }

    public User(Integer id, String name, String username, String pass, String phone, String gmail, String nation, Roles roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.phone = phone;
        this.gmail = gmail;
        this.nation = nation;
        this.roles = roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
