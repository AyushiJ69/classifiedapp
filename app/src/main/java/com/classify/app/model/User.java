package com.classify.app.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="user")
public class User implements Serializable {

    @GeneratedValue
    private @Id @Setter(AccessLevel.PROTECTED) long user_id;
    private String name;
    private String gender;
    private String image;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String country;

    @OneToMany
    @JoinColumn(name="role")
    private List<Role> roles;

}
