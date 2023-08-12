package com.classify.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="contact")
public class Contact {

    private @Id
    @Setter(AccessLevel.PROTECTED) long id;
    private String companyName;
    private String email;
    private String phone;
    private String address;
    private String website;
}
