package com.example.Blog.controller;


import com.example.Blog.model.entities.Post;
import com.example.Blog.model.entities.PostComment;
import com.example.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/post/{postId}")
    public String findPost(@PathVariable Long postId, Model model){

        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post -> {
            model.addAttribute("post", post);
        });

        return "post";
    }


    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable Long postId){

        postRepository.deleteById(postId);

        return "index";
    }

    @PostMapping("/post/addComment")
    public String addComent(@RequestParam String comentBody,@RequestParam Long postId){
        PostComment postComment = new PostComment();
        postComment.setComment(comentBody);

        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post -> {
            post.addComment(postComment);
            postRepository.save(post);
        });

        return "redirect:/post/" + postId;
    }


}
