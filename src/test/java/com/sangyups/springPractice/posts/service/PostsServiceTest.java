package com.sangyups.springPractice.posts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sangyups.springPractice.posts.domain.Posts;
import com.sangyups.springPractice.posts.domain.dto.PostsRequestDto;
import com.sangyups.springPractice.posts.repository.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsServiceTest {

  @Autowired
  private PostsService postsService;

  @Autowired
  private PostsRepository postsRepository;

  @AfterEach
  public void cleanUp() {
    postsRepository.deleteAll();
  }

  @Test
  public void dto데이터를_posts테이블에_저장() {
    // given
    final String expectTitle = "Title";
    final String expectContent = "content";
    final String expectAuthor = "author";

    PostsRequestDto dto = PostsRequestDto.builder()
        .title(expectTitle)
        .content(expectContent)
        .author(expectAuthor)
        .build();

    //when
    postsService.save(dto);

    //then
    Posts post = postsRepository.findAll().get(0);
    assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
    assertThat(post.getContent()).isEqualTo(dto.getContent());
    assertThat(post.getTitle()).isEqualTo(dto.getTitle());
  }

}