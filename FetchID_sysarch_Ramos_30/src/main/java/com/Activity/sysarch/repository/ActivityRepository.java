package com.Activity.sysarch.repository;

import com.Activity.sysarch.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findByBangkasNameContainingIgnoreCase(String bangkasName);
}
