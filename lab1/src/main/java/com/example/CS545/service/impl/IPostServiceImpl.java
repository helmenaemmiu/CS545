package com.example.CS545.service.impl;


import com.example.CS545.entity.Post;
import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.entity.dto.PostDtoV2;
import com.example.CS545.helper.ListMapper;
import com.example.CS545.repo.IPostRepo;
import com.example.CS545.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPostServiceImpl implements IPostService {

    private final IPostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());}


    public PostDto getById(int id ) {
        return modelMapper.map(postRepo.getById(id),  PostDto.class);

    }


    public PostDtoV2 getByIdV2(int id ) {
        return modelMapper.map(postRepo.getById(id),  PostDtoV2.class);

    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id,  PostDto p) {
        postRepo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto>findAllPostsByAuthor(String author){
        return (List<PostDto>) listMapper.mapList(postRepo.findAllPostsByAuthor(author),new PostDto());}


}
