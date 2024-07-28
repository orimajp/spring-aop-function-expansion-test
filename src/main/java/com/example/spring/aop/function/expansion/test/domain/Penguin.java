package com.example.spring.aop.function.expansion.test.domain;

import com.example.spring.aop.function.expansion.test.system.Delegatable;

public interface Penguin extends Bird, Delegatable<Bird> {
  String COMPONENT_KEY = "penguin";

  default String getComponentKey() {
    return COMPONENT_KEY;
  }

  // String getTheAnswerToDoYouLikeSwimming();
  String getTheAnswerToDoYouLikeSwimming(String dummy);

}
