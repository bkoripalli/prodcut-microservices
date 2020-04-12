package com.ms.reviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.reviews.domain.Review;
import com.ms.reviews.repository.ReviewRepository;

@RestController
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepository;
  
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Review> save(@PathVariable("productId") Integer productId, @RequestBody Review review) {
		review.setProductId(productId);
		Review savedReview = reviewRepository.save(review);
		return new ResponseEntity<Review>(savedReview, HttpStatus.OK);
		
	}
	@GetMapping(produces = "application/json")
	public List<Review> findAll(@PathVariable("productId") Integer productId) {
		return reviewRepository.findReviews(productId);
	}
}
