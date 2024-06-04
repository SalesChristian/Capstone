package org.example.repository;

import org.example.model.VacationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacationRequestRepository extends MongoRepository<VacationRequest, String> {
}
