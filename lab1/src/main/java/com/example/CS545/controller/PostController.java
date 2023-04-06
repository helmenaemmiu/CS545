package com.example.CS545.controller;


import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.entity.dto.PostDtoV2;
import com.example.CS545.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PostController {

    private final IPostService postService;


    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll() {
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/ByAuthor/{author}")
    public List<PostDto> getAllByAuthor(@PathVariable String author) {
        return postService.findAllPostsByAuthor(author);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/Bytitle/{title}")
    public List<PostDto> getAllByTitle(@PathVariable String title) {
        return postService.findAllPostsByTitle(title);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable Long id) {
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }
    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<PostDtoV2> getByIdv2(@PathVariable Long id) {
        var post = postService.getByIdV2(id);
        return ResponseEntity.ok(post);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long postId, @RequestBody PostDto p) {
        postService.update(postId,p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }



}
