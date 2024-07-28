package com.example.spring.aop.function.expansion.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

  @GetMapping
  public String index() {
    return "index";
  }

}
