package com.example.msl_b.serivce;


import com.example.msl_b.Domain.Entity.Post;
import com.example.msl_b.Domain.Entity.User;
import com.example.msl_b.Domain.Repository.PostRepository;

import com.example.msl_b.Domain.dto.PostDto;
import com.example.msl_b.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostDto> getBoardlist() {
        List<Post> postEntities = postRepository.findAll();
        List<PostDto> boardDtoList = new ArrayList<>();

        for ( Post post : postEntities) {
            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .nickname(post.getNickname())
                    .content(post.getContent())

                    .createdDate(post.getCreatedDate())
                    .build();

            boardDtoList.add(postDto);
        }

        return boardDtoList;
    }


    @Transactional
    public PostDto update(BigInteger id, PostDto postDto) {
        Optional<Post> boardEntityWrapper = postRepository.findById(id);
        Post boardEntity = boardEntityWrapper.get();

        PostDto postDto1 = PostDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedDate())
                .build();

        return postDto;
    }


    @Transactional
    public  void delete(BigInteger id) {
        // 매개변수 id를 기반으로, 게시글이 존재하는지 먼저 찾음
        // 게시글이 없으면 오류 처리
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        // 게시글이 있는 경우 삭제처리
        postRepository.deleteById(id);

    }

}