package com.example.spring.aop.function.expansion.test.domain;

import com.example.spring.aop.function.expansion.test.system.ExtendedMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PenguinBot implements Penguin {

  private final BirdBot birdBot;

  @Override
  @ExtendedMethod
  // public String getTheAnswerToDoYouLikeSwimming() {
  public String getTheAnswerToDoYouLikeSwimming(String comment) {
    log.info("PenguinBot getTheAnswerToDoYouLikeSwimming comment={}", comment);
    return "Oh, I love swimming. (by PenguinBot)";
  }

  @Override
  public String getTheAnswerToAreYouBird() {
    return "";
  }

  @Override
  @ExtendedMethod
  public String getTheAnswerToDoYouLikeToFly() {
    return "No, I can't fly. (by PenguinBot)";
  }

  @Override
  public Bird getDelegateInstance() {
    return birdBot;
  }

}
