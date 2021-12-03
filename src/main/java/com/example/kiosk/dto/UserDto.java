package com.example.kiosk.dto;

import com.example.kiosk.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private Long usercode;
    private String userId;
    private String name;
    private String password;
    private String phonenum;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .usercode(usercode)
                .userId(userId)
                .name(name)
                .password(password)
                .phonenum(phonenum)
                .build();
    }

    @Builder
    public UserDto(Long usercode, String userId,String name, String password, String phonenum) {
        this.usercode = usercode;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phonenum = phonenum;
    }
}
