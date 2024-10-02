package com.goalKeep.goalKeep.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetail extends User {

    //username(Email), password, authorities
    private final String nickname;  //닉네임
    private final String userId;    //PK

    public CustomUserDetail(String email, String password, Collection<? extends GrantedAuthority> authorities,
                            String nickname, String userId) {
        this.nickname = nickname;
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUserId() {
        return userId;
    }
}
