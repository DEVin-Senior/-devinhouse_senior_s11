package com.example.apireactcrud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="autoridade")
public class AutoridadeUser {
//    @ManyToOne()
    private String username;
    @Id
    private String autoridade;
}
