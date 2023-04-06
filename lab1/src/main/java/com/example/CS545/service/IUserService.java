package com.example.CS545.service;

import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import com.example.CS545.entity.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Iterable<User> findAll();

    Optional<User> getById(Long id );



    void save(User p);

    void delete(Long id);

    void update(Long id, User p);
    Iterable<User> findAllUsersHaveAtLeastTwoPost();
    Iterable<Post>findAllUserPosts(Long userId);

    Iterable<User> findAllUsersHaveAtLeastNPosts(Integer Number);

    Iterable<User> findUsersHavePostWithGivenTitle(String title);

}
