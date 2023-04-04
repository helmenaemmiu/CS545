package com.example.CS545.repo;



import com.example.CS545.entity.Post;

import java.util.List;

public interface IPostRepo {

    public List<Post> findAll();
    public void save(Post p);
    public void delete(int id);

    public void update(int id, Post p);
    public Post getById(int id);
    public List<Post>findAllPostsByAuthor(String author);





}
