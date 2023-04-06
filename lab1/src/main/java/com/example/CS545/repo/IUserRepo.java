package com.example.CS545.repo;



import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepo extends CrudRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> findAllUsersHaveAtLeastTwoPost();


    @Query("SELECT u.posts FROM User u WHERE u.id = ?1")
    List<Post> findAllUserPosts(Long userId);



}
