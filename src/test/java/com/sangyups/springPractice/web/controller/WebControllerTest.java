package com.sangyups.springPractice.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void 메인페이지() {
    // when
    String body = restTemplate.getForObject("/", String.class);

    // then
    assertThat(body).contains("스프링부트를 사용한 웹 서비스");
  }
}