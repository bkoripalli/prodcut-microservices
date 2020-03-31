package com.ms.reviews.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.ms.reviews.domain.Review;
import com.ms.reviews.generator.ReviewSequenceGenerator;

@Component
public class ReviewSequenceEventListener extends AbstractMongoEventListener<Review> {

	private static final String SEQUENCE_NAME = "review_sequences";
	private ReviewSequenceGenerator sequenceGenerator;

	@Autowired
	public ReviewSequenceEventListener(ReviewSequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Review> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGenerator.generateSequence(SEQUENCE_NAME));
		}
	}

}
