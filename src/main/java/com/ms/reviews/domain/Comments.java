package com.ms.reviews.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comments {
	@Id
	long id;
	User commenter;
	String comment;

	public Comments() {
		super();
	}

	public Comments(User commenter, String comment) {
		super();
		this.commenter = commenter;
		this.comment = comment;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Comments [commenter=" + commenter + ", comment=" + comment + "]";
	}

}
