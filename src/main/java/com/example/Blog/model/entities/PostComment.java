package com.example.Blog.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;

    @Embedded
    private AuditEntity auditEntity = new AuditEntity();

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;



}
