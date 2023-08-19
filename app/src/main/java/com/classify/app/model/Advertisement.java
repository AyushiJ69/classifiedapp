package com.classify.app.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="advertisement")
public class Advertisement {
    @GeneratedValue
    @Id
    private @Setter(AccessLevel.PROTECTED) long advertisememt_id;
    private String title;
    private String text;
    private String images;
    private Date postdatetime;
    private String status;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    private String location;
    private Date lastDate;
    private long price;
    private boolean blocked;
}
