package com.example.CS545.controller;


import com.example.CS545.entity.Comment;
import com.example.CS545.entity.dto.CommentDto;
import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.entity.dto.PostDtoV2;
import com.example.CS545.service.ICommentService;
import com.example.CS545.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CommentController {

    private final ICommentService commentService;


    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody CommentDto c) {
        System.out.println(c);
        commentService.save(c);
    }



}
