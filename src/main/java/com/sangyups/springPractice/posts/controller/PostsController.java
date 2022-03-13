package com.sangyups.springPractice.posts.controller;

import com.sangyups.springPractice.posts.domain.dto.PostsRequestDto;
import com.sangyups.springPractice.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsController {

  private final PostsRepository postsRepository;

  @PostMapping("/posts")
  public ResponseEntity<Void> savePosts(@RequestBody PostsRequestDto postsRequestDto) {
    postsRepository.save(postsRequestDto.toEntity());

    return ResponseEntity.status(201).build();
  }
}
