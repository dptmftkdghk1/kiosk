package com.example.kiosk.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long usercode;

    @Column(length = 20, nullable = false)
    private String userId;
    
    @Column(length = 5, nullable = false)
    private String name;
    
    @Column(length = 100, nullable = false)
    private String password;
    
    @Column(length = 8, nullable = false)
    private String phonenum;

    @Builder
    public	UserEntity(Long usercode, String userId,String name, String password, String phonenum) {
        this.usercode = usercode;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phonenum = phonenum;
    }
}