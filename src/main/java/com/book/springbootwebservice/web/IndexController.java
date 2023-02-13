package com.book.springbootwebservice.web;

import com.book.springbootwebservice.domain.Posts.Posts;
import com.book.springbootwebservice.domain.Posts.PostsRepository;
import com.book.springbootwebservice.service.posts.PostsService;
import com.book.springbootwebservice.web.dto.PostsSaveRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String PostsSave() {
        return "posts-save";
    }


}