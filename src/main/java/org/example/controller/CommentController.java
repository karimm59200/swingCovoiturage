package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.dao.CommentRepository;
import org.example.model.Comment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covoiturage")
@AllArgsConstructor
public class CommentController {
    private CommentRepository commentRepository;
    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }
}
