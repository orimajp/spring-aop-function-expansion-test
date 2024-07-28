package com.example.spring.aop.function.expansion.test.system;

public interface ExtensibleComponent {

  String DEFAULT_COMPONENT_KEY = "default";

  default String getComponentKey() {
    return DEFAULT_COMPONENT_KEY;
  }

}
