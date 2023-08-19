package com.classify.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="email")
public class Email {
    @Id
    private long userId;
    private String emailAddress;
    private String otp;

}
