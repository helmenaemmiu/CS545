package com.example.CS545.service.impl;


import com.example.CS545.entity.Comment;
import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import com.example.CS545.entity.dto.CommentDto;
import com.example.CS545.helper.ListMapper;
import com.example.CS545.repo.ICommentRepo;
import com.example.CS545.repo.IUserRepo;
import com.example.CS545.service.ICommentService;
import com.example.CS545.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public Iterable<Comment> findAll() {
        return commentRepo.findAll();
    }
    public Optional<Comment> getById(Long id ) {
        return commentRepo.findById(id);

    }

    @Override
    public void save(CommentDto c) {
        commentRepo.save(modelMapper.map(c, Comment.class));
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(Long id,  Comment c) {
        commentRepo.save(c);
    }
//
//    @Override
//    public Iterable<User>findAllUsersHaveAtLeastTwoPost(){
//        return commentRepo.findAllUsersHaveAtLeastTwoPost();
//    }
//
//    @Override
//    public Iterable<Post>findAllUserPosts(Long userId){
//        return commentRepo.findAllUserPosts(userId);
//    }

}
