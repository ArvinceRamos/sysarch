package com.Activity.sysarch.repository;

import com.Activity.sysarch.model.DestinationPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationPriceRepository extends MongoRepository<DestinationPrice, String> {
    DestinationPrice findByDestination(String destination);
}
