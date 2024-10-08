package com.springboot.project.springboot_webservice_project.service.posts;

import com.springboot.project.springboot_webservice_project.domain.posts.Posts;
import com.springboot.project.springboot_webservice_project.domain.posts.PostsRepository;
import com.springboot.project.springboot_webservice_project.web.dto.PostsResponseDto;
import com.springboot.project.springboot_webservice_project.web.dto.PostsSaveRequestDto;
import com.springboot.project.springboot_webservice_project.web.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
