package com.example.CS545.service.impl;


import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.helper.ListMapper;
import com.example.CS545.repo.IUserRepo;
import com.example.CS545.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }


    public Optional<User> getById(Long id ) {
        return userRepo.findById(id);

    }




    @Override
    public void save(User p) {
        userRepo.save(p);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(Long id,  User p) {
        userRepo.save(p);
    }

    @Override
    public Iterable<User>findAllUsersHaveAtLeastTwoPost(){
        return userRepo.findAllUsersHaveAtLeastTwoPost();
    }

    @Override
    public Iterable<Post>findAllUserPosts(Long userId){
        return userRepo.findAllUserPosts(userId);
    }

    @Override
    public Iterable<User>findAllUsersHaveAtLeastNPosts(Integer number){
        return userRepo.findAllUsersHaveAtLeastNPosts(number);
    }

    @Override
    public Iterable<User>findUsersHavePostWithGivenTitle(String title){
        return userRepo.findUsersHavePostWithGivenTitle(title);
    }
}
