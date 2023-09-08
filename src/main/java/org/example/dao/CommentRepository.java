package org.example.dao;

import org.example.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends MongoRepository<Comment, String> {
}
