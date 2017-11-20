package com.samples.ratc.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samples.ratc.domain.Rate;

@Repository
public interface MongoRateRepository extends MongoRepository<Rate, String> {
	
}