package com.example.feignconfig;

import com.example.feignconfig.bar.BarFeignClient;
import com.example.feignconfig.foo.FooFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @Autowired private FooFeignClient fooFeignClient;
  @Autowired private BarFeignClient barFeignClient;

  @GetMapping("test")
  public void home(@RequestParam String sleep) {
    try {
      LOGGER.info("calling getFoo");
      String foo = fooFeignClient.getFoo(sleep);
      LOGGER.info("foo: {}", foo);
    } catch (Exception e) {
      LOGGER.error("Exception {}", e.getMessage());
    }

    try {
      LOGGER.info("calling getBar");
      String bar = barFeignClient.getBar(sleep);
      LOGGER.info("bar: {}", bar);
    } catch (Exception e) {
      LOGGER.error("Exception {}", e.getMessage());
    }
  }
}
