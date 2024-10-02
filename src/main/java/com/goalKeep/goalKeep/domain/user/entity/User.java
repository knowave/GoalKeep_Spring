package com.goalKeep.goalKeep.domain.user.entity;

import com.goalKeep.goalKeep.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity()
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(length = 255)
    private String profileImage;

    @Column(length = 100)
    private String introduction;

    @Column(length = 128)
    private String token;

    @Column()
    private Boolean isDeleted = false;

    @Column(nullable = false)
    private int planCount = 0;

    @Column(nullable = false)
    private int completedPlanCount = 0;

    @Column(nullable = false)
    private int pendingPlanCount = 0;

    @Column(nullable = false)
    private int feedCount = 0;

    @Column(nullable = false)
    private int followerCount = 0;

    @Column(nullable = false)
    private int followingCount = 0;
}
