package com.example.CS545.repo;



import com.example.CS545.entity.Comment;
import com.example.CS545.entity.Post;
import com.example.CS545.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentRepo extends CrudRepository<Comment, Long> {


}
