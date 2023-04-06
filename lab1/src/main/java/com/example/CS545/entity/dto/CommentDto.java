package com.example.CS545.entity.dto;

import com.example.CS545.entity.Comment;
import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CommentDto {
    String name;
    Post post;
}
