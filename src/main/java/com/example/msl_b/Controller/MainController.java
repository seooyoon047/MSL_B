package com.example.msl_b.Controller;

import com.example.msl_b.Domain.Entity.PostEntity;
import com.example.msl_b.serivce.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private PostService postService;

    @GetMapping("/post/page") //전체 조회
    public List<PostEntity> getPostList() {
        return postService.findAll();
    }

    @GetMapping("/post/{id}") // 상세 조회
    public PostEntity getBook(@PathVariable("id") BigInteger id) {
        return postService.findOne(id);
    }

    @PostMapping("/post") // 작성
    public PostEntity saveBook(@RequestBody PostEntity postEntity) {
        return postService.save(postEntity);
    }

    @PutMapping("/post") //수정
    public PostEntity updateBook(@RequestBody PostEntity postEntity) {
        return postService.update(postEntity);
    }

    @DeleteMapping("/post/{id}") //삭제
    public void deleteBook(@PathVariable("id") BigInteger id) {
        postService.delete(id);
    }
}
