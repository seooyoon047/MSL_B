package com.example.msl_b.Domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "Posts")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String content;

    @Builder
    public Post(BigInteger id, String title, String nickname, String thumbnail, String content) {
       this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
        this.content = content;


    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
