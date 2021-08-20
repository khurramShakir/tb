package com.first.tb.repositories;

import com.first.tb.model.UserBucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBucketRepository extends JpaRepository<UserBucket, Long> {
}