package com.book.springbootwebservice.service.posts;

import com.book.springbootwebservice.domain.Posts.Posts;
import com.book.springbootwebservice.domain.Posts.PostsRepository;
import com.book.springbootwebservice.web.dto.PostsResponseDto;
import com.book.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.book.springbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long Update(Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {

        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해다 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
