package com.sangyups.springPractice.posts.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sangyups.springPractice.posts.domain.Posts;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostsRepositoryTest {

  @Autowired
  private PostsRepository postsRepository;

  @AfterEach
  public void cleanUp() {
    postsRepository.deleteAll();
  }

  @Test
  void 게시글_저장_및_불러오기() {
    // given
    final String expectAuthor = "Sangyup";
    final String expectTitle = "Title";
    final String expectContent = "content";

    postsRepository.save(Posts.builder()
        .author(expectAuthor)
        .title(expectTitle)
        .content(expectContent)
        .build());

    // when
    List<Posts> postsList = postsRepository.findAll();

    // then
    Posts post = postsList.get(0);

    assertThat(post.getAuthor()).isEqualTo(expectAuthor);
    assertThat(post.getTitle()).isEqualTo(expectTitle);
    assertThat(post.getContent()).isEqualTo(expectContent);
  }

  @Test
  void BaseTimeEntity_추가() {
    // given
    LocalDateTime expectDateTime = LocalDateTime.now();
    final String expectAuthor = "Sangyup";
    final String expectTitle = "Title";
    final String expectContent = "content";

    postsRepository.save(Posts.builder()
        .author(expectAuthor)
        .title(expectTitle)
        .content(expectContent)
        .build());

    // when
    List<Posts> postsList = postsRepository.findAll();

    // then
    Posts post = postsList.get(0);

    assertThat(post.getCreatedAt()).isAfter(expectDateTime);
  }

  @Test
  void post를_최신순으로_가져오기() {
    // given
    Posts post1 = Posts.builder()
        .author("")
        .title("")
        .content("")
        .build();

    Posts post2 = Posts.builder()
        .author("")
        .title("")
        .content("")
        .build();

    postsRepository.save(post1);
    postsRepository.save(post2);

    // when
    List<Posts> postsList = postsRepository.findAllByDesc();
    Posts resultPost1 = postsList.get(0);
    Posts resultPost2 = postsList.get(1);

    // then
    assertThat(resultPost1.getCreatedAt()).isAfter(resultPost2.getCreatedAt());
  }
}