package com.example.spring.aop.function.expansion.test;

import com.example.spring.aop.function.expansion.test.domain.Bird;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BirdFactory {

  private final List<Bird> birds;

  private final Map<String, Bird> birdMap = new HashMap<>();

  @PostConstruct
  public void init() {
    birds.forEach(bird -> birdMap.put(bird.getComponentKey(), bird));
  }

  public Bird getBird(String name) {
    return birdMap.getOrDefault(name, birdMap.get(Bird.DEFAULT_COMPONENT_KEY));
  }

}
