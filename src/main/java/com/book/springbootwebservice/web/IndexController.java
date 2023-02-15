package com.book.springbootwebservice.web;

//import com.book.springbootwebservice.config.auth.dto.SessionUser;
import com.book.springbootwebservice.config.auth.dto.SessionUser;
import com.book.springbootwebservice.domain.Posts.Posts;
import com.book.springbootwebservice.domain.Posts.PostsRepository;
import com.book.springbootwebservice.service.posts.PostsService;
import com.book.springbootwebservice.web.dto.PostsResponseDto;
import com.book.springbootwebservice.web.dto.PostsSaveRequestDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAll());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String PostsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}