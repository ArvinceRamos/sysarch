package com.Activity.sysarch.service;

import com.Activity.sysarch.model.Activity;
import com.Activity.sysarch.model.BangkaPrice;
import com.Activity.sysarch.model.DestinationPrice;
import com.Activity.sysarch.repository.ActivityRepository;
import com.Activity.sysarch.repository.BangkaPriceRepository;
import com.Activity.sysarch.repository.DestinationPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DestinationPriceRepository destinationPriceRepository;

    @Autowired
    private BangkaPriceRepository bangkaPriceRepository;

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public List<Activity> searchActivitiesByBangkasName(String bangkasName) {
        return activityRepository.findByBangkasNameContainingIgnoreCase(bangkasName);
    }

    public int getDestinationPrice(String destination) {
        DestinationPrice destinationPrice = destinationPriceRepository.findByDestination(destination);
        return destinationPrice != null ? destinationPrice.getPrice() : 0;
    }

    public int getBangkaPrice(String bangkasName) {
        BangkaPrice bangkaPrice = bangkaPriceRepository.findByBangkaName(bangkasName);
        return bangkaPrice != null ? bangkaPrice.getPrice() : 0;
    }
}
