package com.example.CS545.repo;



import com.example.CS545.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPostRepo  extends CrudRepository<Post, Long> {

//    public List<Post> findAll();
//    public void save(Post p);
//    public void delete(int id);
//
//    public void update(int id, Post p);
//    public Post getById(int id);
//    public List<Post>findAllPostsByAuthor(String author);

    @Query("SELECT p FROM Post p WHERE p.author = ?1")
    List<Post> findAllPostsByAuthor(String author);



}
