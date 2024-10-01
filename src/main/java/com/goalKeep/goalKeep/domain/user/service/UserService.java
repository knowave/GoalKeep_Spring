package com.goalKeep.goalKeep.domain.user.service;

import com.goalKeep.goalKeep.domain.user.dto.UserDto;
import com.goalKeep.goalKeep.domain.user.repository.UserRepository;
import com.goalKeep.goalKeep.global.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void createUser(UserDto.Request createUserDto) {
        if (userRepository.existByEmail(createUserDto.getEmail())) {
            throw new CustomException("이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST);
        }

        createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
        userRepository.save(createUserDto.toEntity());
    }
}
