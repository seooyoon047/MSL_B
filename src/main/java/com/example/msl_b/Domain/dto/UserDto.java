package com.example.msl_b.Domain.dto;

import com.example.msl_b.Domain.Entity.User;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private BigInteger id;
    private String nickname;
    private String password;

    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public User toEntity(){
        return User.builder()
                .id(id)
                .nickname(nickname)
                .password(password)
                .name(name)

                .build();
    }

    @Builder
    public UserDto(BigInteger id, String nickname, String password, String name, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.nickname = password;
        this.password = nickname;
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}