package com.Activity.sysarch.controller;

import com.Activity.sysarch.model.Activity;
import com.Activity.sysarch.service.ActivityService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = {"http://localhost:8080", "http://your-frontend-domain.com"}) // Add your frontend URL here
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/search")
    public List<Activity> searchActivities(@RequestParam String bangkasName) {
        return activityService.searchActivitiesByBangkasName(bangkasName);
    }

    @PostMapping
    public Activity createActivity(
            @Parameter(in = ParameterIn.QUERY, description = "Name of the destination", schema = @Schema(allowableValues = {"Bantayan", "Camotes", "Bohol", "Moalboal", "Olanggo", "Sumilon", "Malapascua", "Alegria"}))
            @RequestParam String destination,
            @Parameter(in = ParameterIn.QUERY, description = "Name of the bangka", schema = @Schema(allowableValues = {"MV Cebu", "MV Banilad", "MV Xerxes", "MV Odette", "MV James", "MV Melgo", "MV Arvince", "MV Joem"}))
            @RequestParam String bangkasName) {
        int destinationPrice = activityService.getDestinationPrice(destination);
        int bangkaPrice = activityService.getBangkaPrice(bangkasName);
        Activity activity = new Activity();
        activity.setDestination(destination);
        activity.setBangkasName(bangkasName);
        activity.setDate(new Date());
        activity.setTotalPrice(destinationPrice + bangkaPrice);
        return activityService.saveActivity(activity);
    }
}
