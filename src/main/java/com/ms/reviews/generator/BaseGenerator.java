package com.ms.reviews.generator;

import org.springframework.data.mongodb.core.MongoOperations;

public abstract class BaseGenerator {

	protected MongoOperations mongoOperations;
    public abstract long generateSequence(String seqName);

	
}
