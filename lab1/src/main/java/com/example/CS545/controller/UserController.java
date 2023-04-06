package com.example.CS545.controller;


import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import com.example.CS545.entity.dto.PostDto;
import com.example.CS545.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    private final IUserService userService;


    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
        System.out.println(id);
        var user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/posts")
    public Iterable<Post> getAllByAuthor(@PathVariable Long userId) {
        return userService.findAllUserPosts(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersmorethanonepost")
    public Iterable<User> findAllUsersHaveAtLeastTwoPost() {
        return userService.findAllUsersHaveAtLeastTwoPost();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersmorethannpost/{number}")
    public Iterable<User> findAllUsersHaveAtLeastNPosts(@PathVariable Integer number) {
        return userService.findAllUsersHaveAtLeastNPosts(number);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersByTitle/{title}")
    public Iterable<User> findUsersHavePostWithGivenTitle(@PathVariable String title) {
        return userService.findUsersHavePostWithGivenTitle(title);
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody User p) {
        userService.save(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long userId, @RequestBody User p) {
        userService.update(userId,p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }



}
