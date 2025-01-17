package com.springboot.project.springboot_webservice_project.web;

import com.springboot.project.springboot_webservice_project.domain.posts.Posts;
import com.springboot.project.springboot_webservice_project.service.posts.PostsService;
import com.springboot.project.springboot_webservice_project.web.dto.PostsResponseDto;
import com.springboot.project.springboot_webservice_project.web.dto.PostsSaveRequestDto;
import com.springboot.project.springboot_webservice_project.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }


    //수정/조회 기능 만들기
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //게시글 삭제 기능 만들기
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }


}
