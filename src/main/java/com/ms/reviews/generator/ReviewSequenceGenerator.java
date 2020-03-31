package com.ms.reviews.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import com.ms.reviews.domain.ReviewSequence;

@Component
public class ReviewSequenceGenerator extends BaseGenerator {

	@Autowired
	public ReviewSequenceGenerator(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public long generateSequence(String seqName) {
		ReviewSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), ReviewSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
