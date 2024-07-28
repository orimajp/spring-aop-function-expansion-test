package com.example.spring.aop.function.expansion.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BirdBot implements Bird {

  @Override
  // public String getTheAnswerToAreYouBird() {
  public String getTheAnswerToAreYouBird(String comment) {
    log.info("BirdBot getTheAnswerToAreYouBird comment {}", comment);
    return "That's right. I'm a bird. (by BirdBot)";
  }

  @Override
  public String getTheAnswerToDoYouLikeToFly() {
    return "Oh, I love flying. (by BirdBot)";
  }

}
