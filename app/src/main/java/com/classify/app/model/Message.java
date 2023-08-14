package com.classify.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="message")
public class Message {
    @GeneratedValue
    private @Id
    @Setter(AccessLevel.PROTECTED) long id;
    private String text;
    private long senderId;
    private long receiverId;
    private LocalDate datetime;

}
