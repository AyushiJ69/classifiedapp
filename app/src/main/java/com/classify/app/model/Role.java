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
@Table(name="role")
public class Role {
    private @Id
    @Setter(AccessLevel.PROTECTED) long id;
    private String name;
}
