package com.sangyups.springPractice.posts.domain.dto;

import com.sangyups.springPractice.posts.domain.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostsRequestDto {

  private String title;

  private String content;

  private String author;

  @Builder
  public PostsRequestDto(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public Posts toEntity() {
    return Posts.builder()
        .title(title)
        .content(content)
        .author(author)
        .build();
  }
}
