package com.sangyups.springPractice.posts.controller;

import com.sangyups.springPractice.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsController {

  private final PostsRepository postsRepository;

  
}
