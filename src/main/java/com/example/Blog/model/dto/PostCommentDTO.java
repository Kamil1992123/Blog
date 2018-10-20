package com.example.Blog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDTO {

    private Long id;
    private String comment;
    private Date added;
}
