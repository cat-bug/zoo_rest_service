package com.sample.zoorestservice.repo;

import com.sample.zoorestservice.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends MongoRepository<Show, String> {
}
