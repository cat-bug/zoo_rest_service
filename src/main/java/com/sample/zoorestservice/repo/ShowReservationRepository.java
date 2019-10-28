package com.sample.zoorestservice.repo;

import com.sample.zoorestservice.model.ShowReservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowReservationRepository extends MongoRepository<ShowReservation, String> {
}
