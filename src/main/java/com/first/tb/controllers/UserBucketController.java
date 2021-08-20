package com.first.tb.controllers;

import com.first.tb.model.User;
import com.first.tb.model.UserBucket;
import com.first.tb.repositories.UserBucketRepository;
import com.first.tb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserBucketController {
    @Autowired
    UserBucketRepository userBucketRepository;


    /**
     * Get all user Buckets list.
     *
     * @return the list
     */
    @GetMapping("/buckets")
    public List<UserBucket> getBuckets() {
        return userBucketRepository.findAll();
    }

    /**
     * Gets All buckets by user Id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws Exception the resource not found exception
     */
    @GetMapping("/buckets/{id}")
    public ResponseEntity<UserBucket> getBucketsById(@PathVariable(value = "id") Long userId)
            throws Exception {
        UserBucket bucket =
                userBucketRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("Bucket not found on :: " + userId));
        return ResponseEntity.ok().body(bucket);
    }

    /**
     * Create  userBucket.
     *
     * @param userBucket the userBucket
     * @return the userBucket
     */
    @PostMapping("/buckets")
    public UserBucket createUser(@Valid @RequestBody UserBucket userBucket) {
        return userBucketRepository.save(userBucket);
    }

    /**
     * Update userBucket response entity.
     *
     * @param userBucketId the user id
     * @param bucketDetails the user details
     * @return the response entity
     * @throws Exception the resource not found exception
     */
    @PutMapping("/buckets/{id}")
    public ResponseEntity<UserBucket> updateUser(
            @PathVariable(value = "userBucketId") Long userBucketId, @Valid @RequestBody UserBucket bucketDetails)
            throws Exception {

        UserBucket userBucket =
                userBucketRepository
                        .findById(userBucketId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userBucketId));

        userBucket.setName(bucketDetails.getName());
        userBucket.setCost(bucketDetails.getCost());
        userBucket.setSize(bucketDetails.getSize());
        final UserBucket updatedUserBucket = userBucketRepository.save(userBucket);
        return ResponseEntity.ok(updatedUserBucket);
    }

    /**
     * Delete user map.
     *
     * @param bucketId the user Bucket id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/buckets/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long bucketId) throws Exception {
        UserBucket userBucket =
                userBucketRepository
                        .findById(bucketId)
                        .orElseThrow(() -> new Exception("User not found on :: " + bucketId));

        userBucketRepository.delete(userBucket);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
