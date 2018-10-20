package com.example.Blog.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id // unikalna kolumna w bazie danych(id+1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;


    @Embedded
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> comments = new HashSet<>();





}
