package com.softserve.ita.demo1.entities;

import com.softserve.ita.demo1.enums.UserRole;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class User {

    private Integer id;
    private String name;
    private String password;
    private String email;

    private UserRole role;

    public User(){
        this.role = UserRole.USER;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = UserRole.USER;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean isAdmin()
    {
        return this.role == UserRole.ADMIN;
    }

    public void setRole(String role) {
        this.role = UserRole.valueOf(role);
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, role);
    }


}
