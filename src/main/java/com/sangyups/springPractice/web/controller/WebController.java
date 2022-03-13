package com.sangyups.springPractice.web.controller;

import com.sangyups.springPractice.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

  private final PostsService postsService;

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("posts", postsService.getPostsByRecent());
    return "index";
  }
}
