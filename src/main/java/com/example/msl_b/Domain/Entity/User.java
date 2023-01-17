package com.example.msl_b.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private BigInteger id;
    @Column(nullable = false)
    private String nickname;
    @JsonIgnore
    @Column(nullable = false)
    private String password;



    @Column(nullable = false)
    private String name;



    @Builder
    public User(BigInteger id, String nickname, String password, String name){
        this.id= id;
        this.nickname = nickname;
        this.password = password;
        this.name = name;



    }



}