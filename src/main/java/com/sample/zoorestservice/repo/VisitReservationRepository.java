package com.sample.zoorestservice.repo;

import com.sample.zoorestservice.model.VisitReservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitReservationRepository extends MongoRepository<VisitReservation, String> {
}
