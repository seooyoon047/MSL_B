package com.example.msl_b.serivce;


import com.example.msl_b.Domain.Entity.PostEntity;
import com.example.msl_b.Domain.Repository.PostRepository;

import com.example.msl_b.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    public PostEntity findOne(BigInteger id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PostEntity", "id", id));
    }

    @Transactional
    public PostEntity save(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    @Transactional
    public PostEntity update(PostEntity postEntity) {

        return postRepository.save(postEntity);
    }

    @Transactional
    public void delete(BigInteger id) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PostEntity", "id", id));
        postRepository.delete(postEntity);
    }
}