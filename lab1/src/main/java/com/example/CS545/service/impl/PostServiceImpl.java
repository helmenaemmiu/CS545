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
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());}


    public PostDto getById(Long id ) {
        return modelMapper.map(postRepo.findById(id),  PostDto.class);

    }


    public PostDtoV2 getByIdV2(Long id ) {
        return modelMapper.map(postRepo.findById(id),  PostDtoV2.class);

    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(Long id,  PostDto p) {
        postRepo.save( modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto>findAllPostsByAuthor(String author){
        return (List<PostDto>) listMapper.mapList(postRepo.findAllPostsByAuthor(author),new PostDto());}


}
