package com.goalKeep.goalKeep.domain.user.controller;

import com.goalKeep.goalKeep.domain.user.dto.UserDto;
import com.goalKeep.goalKeep.domain.user.entity.User;
import com.goalKeep.goalKeep.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UserDto.Request createUserDto) {
        userService.createUser(createUserDto);
        return ResponseEntity.ok().body("SUCCESS!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> myProfile() {

    }
}
