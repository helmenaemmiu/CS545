package com.example.CS545.service;

import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.entity.dto.PostDtoV2;

import java.util.List;

public interface IPostService {

    public List<PostDto> findAll();

    PostDto getById(int id );
    PostDtoV2 getByIdV2(int id );



    void save(PostDto p);

    void delete(int id);

    void update(int id, PostDto p);
    List<PostDto>findAllPostsByAuthor(String author);
}
