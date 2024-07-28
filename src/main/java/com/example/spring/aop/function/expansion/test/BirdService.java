package com.example.spring.aop.function.expansion.test;

import com.example.spring.aop.function.expansion.test.domain.Bird;
import com.example.spring.aop.function.expansion.test.domain.Penguin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirdService {

  private final BirdFactory birdFactory;

  public Bird getBird(String name) {
    return birdFactory.getBird(name);
  }

  public String getTheAnswerToAreYouBird(String name) {
    return getBird(name).getTheAnswerToAreYouBird();
  }

  public String getTheAnswerToDoYouLikeToFly(String name) {
    return getBird(name).getTheAnswerToDoYouLikeToFly();
  }

  public String getTheAnswerToDoYouLikeSwimming(String name) {
    // return ((Penguin)getBird(name)).getTheAnswerToDoYouLikeSwimming();
    return ((Penguin) getBird(name)).getTheAnswerToDoYouLikeSwimming("test comment");
  }

}
