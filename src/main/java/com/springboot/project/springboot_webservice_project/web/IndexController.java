package com.springboot.project.springboot_webservice_project.web;

import com.springboot.project.springboot_webservice_project.service.posts.PostsService;
import com.springboot.project.springboot_webservice_project.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    /* (4.3) /posts/save 호출시 posts-save.mustache를 호출하는 메소드  */
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    /* 게시글 수정 화면 연결 */
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
