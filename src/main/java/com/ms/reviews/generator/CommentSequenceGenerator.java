package com.ms.reviews.generator;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.ms.reviews.domain.CommentsSequence;;

@Component
public class CommentSequenceGenerator extends BaseGenerator {

	@Autowired
	public CommentSequenceGenerator(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public long generateSequence(String seqName) {
		CommentsSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), CommentsSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
