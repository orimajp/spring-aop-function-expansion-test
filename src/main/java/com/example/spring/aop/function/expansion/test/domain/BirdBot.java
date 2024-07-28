package com.example.spring.aop.function.expansion.test.domain;

import org.springframework.stereotype.Component;

@Component
public class BirdBot implements Bird {

  @Override
  public String getTheAnswerToAreYouBird() {
    return "That's right. I'm a bird. (by BirdBot)";
  }

  @Override
  public String getTheAnswerToDoYouLikeToFly() {
    return "Oh, I love flying. (by BirdBot)";
  }

}
