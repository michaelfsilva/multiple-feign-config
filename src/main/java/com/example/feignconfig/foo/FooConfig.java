package com.example.feignconfig.foo;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FooConfig {

  //  @Bean
  //  public FooRequestInterceptor fooRequestInterceptor() {
  //    return new FooRequestInterceptor();
  //  }

  @Value("${microservice.foo.feign.connect-timeout}")
  private int feignConnectTimeout;

  @Value("${microservice.foo.feign.read-timeout}")
  private int feignReadTimeout;

  //  @Value("${microservice.foo.hystrix.timeout}")
  //  private Long hystrixTimeout;

  //  @Bean
  //  @Scope("prototype")
  //  public Feign.Builder feignBuilder() {
  //    var feignConnectTimeoutMillis = (int)
  // Duration.ofMillis(this.feignConnectTimeout).toMillis();
  //    var feignReadTimeoutMillis = (int) Duration.ofMillis(this.feignReadTimeout).toMillis();
  //    var hystrixTimeoutMillis = (int) Duration.ofMillis(this.hystrixTimeout).toMillis();
  //
  //    return (HystrixFeign.builder()
  //            .options(new Request.Options(feignConnectTimeoutMillis, feignReadTimeoutMillis))
  //            .setterFactory(
  //                (target, method) ->
  //                    new SetterFactory.Default()
  //                        .create(target, method)
  //                        .andCommandPropertiesDefaults(
  //                            HystrixCommandProperties.Setter()
  //                                .withExecutionTimeoutInMilliseconds(hystrixTimeoutMillis))))
  //        .retryer(Retryer.NEVER_RETRY);
  //  }

  @Bean
  public Request.Options options() {
    return new Request.Options(feignConnectTimeout, feignReadTimeout);
  }
}
