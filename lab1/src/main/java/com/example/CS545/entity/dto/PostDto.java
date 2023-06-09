package com.example.CS545.entity.dto;

import com.example.CS545.entity.Comment;
import com.example.CS545.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class PostDto  {
    String title;
    String content;
    String author;
    User user;
    List<Comment> comments;
}
