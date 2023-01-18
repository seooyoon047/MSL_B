package com.example.msl_b.Domain.dto;

import com.example.msl_b.Domain.Entity.Post;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String writer;

    public static PostDto toEntity(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getName());
    }

}