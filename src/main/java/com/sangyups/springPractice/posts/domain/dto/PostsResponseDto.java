package com.sangyups.springPractice.posts.domain.dto;

import static com.sangyups.springPractice.common.Utils.toStringDateTime;

import com.sangyups.springPractice.posts.domain.Posts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostsResponseDto {

  private Long id;

  private String title;

  private String author;

  private String content;

  private String modifiedAt;

  @Builder
  public PostsResponseDto(Long id, String title, String author, String content, String modifiedAt) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.content = content;
    this.modifiedAt = modifiedAt;
  }

  public static PostsResponseDto of(Posts post) {
    return PostsResponseDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .author(post.getAuthor())
        .content(post.getContent())
        .modifiedAt(toStringDateTime(post.getModifiedAt()))
        .build();
  }


}
