package com.sangyups.springPractice.posts.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostsRepositoryTest {

  private final PostsRepository postsRepository;

  public PostsRepositoryTest(
      PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  @AfterEach
  public void cleanUp() {
    postsRepository.deleteAll();
  }

}