package com.example.feignconfig.bar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "barValue",
    url = "https://httpstat.us/200") // , configuration = BarConfig.class)
public interface BarFeignClient {

  @GetMapping
  String getBar(@RequestParam("sleep") String sleep);
}
