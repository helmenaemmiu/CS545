package com.example.CS545.service;

import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.entity.dto.PostDtoV2;

import java.util.List;

public interface IPostService {

    public List<PostDto> findAll();

    PostDto getById(Long id );
    PostDtoV2 getByIdV2(Long id );



    void save(PostDto p);

    void delete(Long id);

    void update(Long id, PostDto p);
    List<PostDto>findAllPostsByAuthor(String author);

    List<PostDto>findAllPostsByTitle(String title);
}
