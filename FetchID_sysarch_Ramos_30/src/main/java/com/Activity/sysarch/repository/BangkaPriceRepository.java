package com.Activity.sysarch.repository;

import com.Activity.sysarch.model.BangkaPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BangkaPriceRepository extends MongoRepository<BangkaPrice, String> {
    BangkaPrice findByBangkaName(String bangkaName);
}
