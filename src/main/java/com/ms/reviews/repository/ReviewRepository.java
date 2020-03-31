package com.ms.reviews.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ms.reviews.domain.Review;

public interface ReviewRepository extends MongoRepository<Review, Long> {
	@Query("{'productId' : ?0}")
	List<Review> findReviews(Integer productId);
}
