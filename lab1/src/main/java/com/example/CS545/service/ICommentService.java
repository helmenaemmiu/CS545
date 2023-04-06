package com.example.CS545.service;

import com.example.CS545.entity.Comment;
import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import com.example.CS545.entity.dto.CommentDto;

import java.util.Optional;

public interface ICommentService {

    public Iterable<Comment> findAll();

    Optional<Comment> getById(Long id );



    void save(CommentDto c);

    void delete(Long id);

    void update(Long id, Comment c);

}
