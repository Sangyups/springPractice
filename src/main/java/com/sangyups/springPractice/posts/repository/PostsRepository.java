package com.sangyups.springPractice.posts.repository;

import com.sangyups.springPractice.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
  
}
