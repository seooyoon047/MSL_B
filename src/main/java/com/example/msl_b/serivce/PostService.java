package com.example.msl_b.serivce;


import com.example.msl_b.Domain.Entity.Post;
import com.example.msl_b.Domain.Entity.User;
import com.example.msl_b.Domain.Repository.PostRepository;

import com.example.msl_b.Domain.dto.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 전체 게시물 조회
    @Transactional(readOnly = true)
    public List<PostDto> getBoards() {
        List<Post> boards = postRepository.findAll();
        List<PostDto> boardDtos = new ArrayList<>();
        boards.forEach(s -> boardDtos.add(PostDto.toEntity(s)));
        return boardDtos;
    }

    // 개별 게시물 조회
    @Transactional(readOnly = true)
    public PostDto getBoard(BigInteger id) {
        Post board = postRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다.");
        });
        PostDto postDto = PostDto.toEntity(board);
        return postDto;
    }

    // 게시물 작성
    @Transactional
    public PostDto write(PostDto postDto, User user) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setUser(user);
        postRepository.save(post);
        return PostDto.toEntity(post);
    }

    // 게시물 수정
    @Transactional
    public PostDto update(BigInteger id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        return PostDto.toEntity(post);
    }


    // 게시글 삭제
    @Transactional
    public void delete(BigInteger id) {
        // 매개변수 id를 기반으로, 게시글이 존재하는지 먼저 찾음
        // 게시글이 없으면 오류 처리
        Post post = postRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        // 게시글이 있는 경우 삭제처리
        postRepository.deleteById(id);

    }
}