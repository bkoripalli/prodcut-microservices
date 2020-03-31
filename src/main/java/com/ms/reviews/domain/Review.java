package com.ms.reviews.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
	@Id
	long id;
	long productId;
	User reviewer;
	String description;
	boolean helpful;
	@CreatedDate
	Date createdDate;

	public Review() {
		super();
	}

	public Review(Integer id, User reviewer, String description, boolean helpful) {
		super();
		this.id = id;
		this.reviewer = reviewer;
		this.description = description;
		this.helpful = helpful;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHelpful() {
		return helpful;
	}

	public void setHelpful(boolean helpful) {
		this.helpful = helpful;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewer=" + reviewer + ", description=" + description + ", helpful=" + helpful
				+ "]";
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
