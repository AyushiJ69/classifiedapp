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
@Table(name="category")
public class Category {
    private @Id
    @Setter(AccessLevel.PROTECTED) long category_id;
    private String name;
}
