package com.example.spring.aop.function.expansion.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiController {

  private final BirdService birdService;

  @GetMapping("question1/{name}")
  public ResponseEntity<Object> question1(@PathVariable String name) {
    var answer = birdService.getTheAnswerToAreYouBird(name);
    return ResponseEntity.ok(answer);
  }

  @GetMapping("question2/{name}")
  public ResponseEntity<Object> question2(@PathVariable String name) {
    var answer = birdService.getTheAnswerToDoYouLikeToFly(name);
    return ResponseEntity.ok(answer);
  }

  @GetMapping("question3/{name}")
  public ResponseEntity<Object> question3(@PathVariable String name) {
    var answer = birdService.getTheAnswerToDoYouLikeSwimming(name);
    return ResponseEntity.ok(answer);
  }

}
