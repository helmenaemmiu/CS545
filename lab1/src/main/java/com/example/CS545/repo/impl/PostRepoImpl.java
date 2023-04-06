package com.example.CS545.repo.impl;

import com.example.CS545.entity.Post;
import com.example.CS545.repo.IPostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl //implements IPostRepo
         {
    private static List<Post> posts;
    private static Long postId = 300L;
    static {
        posts = new ArrayList<>();


        Post p1 = new Post(111L,"post1","post content 1","hossam");
        Post p2 = new Post(222L,"post2","post content 2","ahmed");
        posts.add(p1);
        posts.add(p2);
    }


    public List<Post> findAll(){
        return posts;
    }





    public void delete(int id) {
        var post =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
            posts.remove(post);
    }


    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setContent(p.getContent());
    }

    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

//    @Override
//    public List<Post>findAllPostsByAuthor(String author){
//        return posts.stream()
//                .filter(p -> p.getAuthor()==author)
//                .collect(Collectors.toList());
//    }



}
