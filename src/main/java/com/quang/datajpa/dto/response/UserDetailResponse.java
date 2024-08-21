package com.quang.datajpa.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Getter
@Builder
public class UserDetailResponse implements Serializable {
    private String firtName;
    private String lastName;
    private String email;
    private String phone;
}
