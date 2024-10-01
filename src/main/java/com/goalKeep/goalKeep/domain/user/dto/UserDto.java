package com.goalKeep.goalKeep.domain.user.dto;

import com.goalKeep.goalKeep.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public class UserDto {

    @Data
    public static class Request {
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @NotEmpty(message = "이메일을 입력해주세요.")
        private String email;

        @NotEmpty(message = "닉네임을 입력해주세요")
        @Pattern(regexp = "^[가-힣a-zA-Z]{2,20}$", message = "닉네임은 한글, 영문 2~20자로 입력해주세요")
        private String nickname;

        @NotEmpty(message = "비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$", message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8~20자로 입력해주세요")
        private String password;

        @NotEmpty(message = "전화번호를 입력해주세요")
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식에 맞게 입력해주세요")
        private String phoneNumber;

        @Max(value = 100, message = "소개글은 100자 이하로 작성해주세요.")
        private String introduction;

        // 프로필 이미지는 선택 사항이라 nullable 하게 처리.
        private String profileImage;

        public User toEntity() {
            User user = User.builder()
                    .email(email)
                    .nickname(nickname)
                    .password(password)
                    .phoneNumber(phoneNumber)
                    .introduction(introduction)
                    .profileImage(profileImage)
                    .build();

            return user;
        }
    }
}
