package com.example.feignconfig.foo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "fooValue",
    url = "https://httpstat.us/201") // , configuration = FooConfig.class)
public interface FooFeignClient {

  @GetMapping
  String getFoo(@RequestParam("sleep") String sleep);
}
