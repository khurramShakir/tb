package com.first.tb.controllers;

import com.first.tb.model.Activity;
import com.first.tb.model.Activity;
import com.first.tb.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserActivityController {
    @Autowired
    ActivityRepository activityRepository;


    /**
     * Get all user Buckets list.
     *
     * @return the list
     */
    @GetMapping("/activity")
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    /**
     * Gets All Activities by user Id.
     *
     * @param activityId the Activity Id
     * @return the users by id
     * @throws Exception the resource not found exception
     */
    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable(value = "id") Long activityId)
            throws Exception {
        Activity a = new Activity();
        a.setDescription("Hello world");
        a.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Activity activity =
                activityRepository
                        .findById(activityId).orElse((a)) ;
                        //.orElseThrow(() -> new Exception("Bucket not found on :: " + activityId));
        return ResponseEntity.ok().body(activity);
    }

    /**
     * Create  Activity.
     *
     * @param Activity the Activity
     * @return the Activity
     */
    @PostMapping("/activity")
    public Activity createUser(@Valid @RequestBody Activity Activity) {
        return activityRepository.save(Activity);
    }

    /**
     * Update Activity response entity.
     *
     * @param ActivityId the user id
     * @param activityDetails the user details
     * @return the response entity
     * @throws Exception the resource not found exception
     */
    @PutMapping("/activity/{id}")
    public ResponseEntity<Activity> updateUser(
            @PathVariable(value = "ActivityId") Long ActivityId, @Valid @RequestBody Activity activityDetails)
            throws Exception {

        Activity activity =
                activityRepository
                        .findById(ActivityId)
                        .orElseThrow(() -> new Exception("User not found on :: " + ActivityId));

        activity.setDescription(activityDetails.getDescription());
        activity.setActivityTime(activityDetails.getActivityTime());
        activity.setCreatedAt(activityDetails.getCreatedAt());
        final Activity updatedActivity = activityRepository.save(activity);
        return ResponseEntity.ok(updatedActivity);
    }

    /**
     * Delete user map.
     *
     * @param activityId the Activity Id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/activity/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long activityId) throws Exception {
        Activity Activity =
                activityRepository
                        .findById(activityId)
                        .orElseThrow(() -> new Exception("User not found on :: " + activityId));

        activityRepository.delete(Activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
