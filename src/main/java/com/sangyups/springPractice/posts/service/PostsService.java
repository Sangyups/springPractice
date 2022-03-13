package com.sangyups.springPractice.posts.service;

import com.sangyups.springPractice.posts.domain.dto.PostsRequestDto;
import com.sangyups.springPractice.posts.repository.PostsRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsRequestDto dto) {
    return postsRepository.save(dto.toEntity()).getId();
  }
}
