package com.quang.datajpa.service;

import com.quang.datajpa.dto.request.UserRequestDTO;
import com.quang.datajpa.dto.response.UserDetailResponse;
import com.quang.datajpa.utils.UserStatus;

import java.util.List;


public interface UserService {

    long saveUser(UserRequestDTO request);

    void updateUser(long userId, UserRequestDTO request);

    void changeStatus(long userId, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    List<UserDetailResponse> getAllUsers(int pageNo, int pageSize);
}
