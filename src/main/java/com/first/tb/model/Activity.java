package com.first.tb.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "activity")
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "activity_time")
    private Timestamp activityTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_bucket_id", nullable = false)
    private UserBucket userBucket;

    public UserBucket getUserBucket() {
        return userBucket;
    }

    public void setUserBucket(UserBucket userBucket) {
        this.userBucket = userBucket;
    }

    public Timestamp getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Timestamp activityTime) {
        this.activityTime = activityTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}