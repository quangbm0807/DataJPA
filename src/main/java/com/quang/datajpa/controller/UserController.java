package com.quang.datajpa.controller;


import com.quang.datajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
@Tag(name ="User Controller")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

}
