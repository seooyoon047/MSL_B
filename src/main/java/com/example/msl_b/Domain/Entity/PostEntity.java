package com.example.msl_b.Domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "Post")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column
    private String nickname;
    @Column
    private String thumbnail;

    @Column(length = 100, nullable = false)
    private String content;

    @Builder
    public PostEntity(String title, String nickname, String thumbnail, String content) {
        this.title = title;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
        this.content = content;


    }
}
