package com.ms.reviews.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.reviews.domain.Comments;

public interface CommentRepository extends MongoRepository<Comments, Long> {


}
