package com.ms.reviews.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.ms.reviews.domain.Comments;
import com.ms.reviews.generator.CommentSequenceGenerator;

@Component
public class CommentSequenceEventListener extends AbstractMongoEventListener<Comments> {
	
	private static final String SEQUENCE_NAME = "comments_sequences";
	private CommentSequenceGenerator sequenceGenerator;

	@Autowired
	public CommentSequenceEventListener(CommentSequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Comments> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGenerator.generateSequence(SEQUENCE_NAME));
		}
	}

}
