package com.sangyups.springPractice.posts.service;

import com.sangyups.springPractice.posts.domain.dto.PostsRequestDto;
import com.sangyups.springPractice.posts.domain.dto.PostsResponseDto;
import com.sangyups.springPractice.posts.repository.PostsRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostsService {

  private final PostsRepository postsRepository;

  public Long save(PostsRequestDto dto) {
    return postsRepository.save(dto.toEntity()).getId();
  }

  @Transactional(readOnly = true)
  public List<PostsResponseDto> getPostsByRecent() {
    return postsRepository.findAllByDesc().stream()
        .map(PostsResponseDto::of)
        .collect(Collectors.toList());
  }
}
