package com.example.feignconfig.bar;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

// @Configuration TODO: DO NOT USE CONFIGURATION FOR FEIGN CONFIGS
public class BarConfig {

  //  @Bean
  //  public BarRequestInterceptor barRequestInterceptor() {
  //    return new BarRequestInterceptor();
  //  }

  //  @Value("${microservice.bar.hystrix.enabled:true}")
  //  private Boolean hystrixEnabled;

  //    @DurationUnit(value = ChronoUnit.MILLIS)
  @Value("${microservice.bar.feign.connect-timeout}")
  private int feignConnectTimeout;

  //    @DurationUnit(value = ChronoUnit.MILLIS)
  @Value("${microservice.bar.feign.read-timeout}")
  private int feignReadTimeout;

  //    @DurationUnit(value = ChronoUnit.MILLIS)
  //  @Value("${microservice.bar.hystrix.timeout}")
  //  private Long hystrixTimeout;

  //  @Bean
  //  @Scope("prototype")
  //  public Feign.Builder feignBuilder() {
  //    var feignConnectTimeoutMillis = (int)
  // Duration.ofMillis(this.feignConnectTimeout).toMillis();
  //    var feignReadTimeoutMillis = (int) Duration.ofMillis(this.feignReadTimeout).toMillis();
  //    var hystrixTimeoutMillis = (int) Duration.ofMillis(this.hystrixTimeout).toMillis();
  //
  //    //        var feignConnectTimeoutMillis = (int) this.feignConnectTimeout.toMillis();
  //    //        var feignReadTimeoutMillis = (int) this.feignReadTimeout.toMillis();
  //
  //    return (
  //        //                hystrixEnabled ?
  //        HystrixFeign.builder()
  //            .options(new Request.Options(feignConnectTimeoutMillis, feignReadTimeoutMillis))
  //            .setterFactory(
  //                (target, method) ->
  //                    new SetterFactory.Default()
  //                        .create(target, method)
  //                        .andCommandPropertiesDefaults(
  //                            HystrixCommandProperties.Setter()
  //                                .withExecutionTimeoutInMilliseconds(hystrixTimeoutMillis)))
  //        //                :
  //        //                Feign.builder()
  //        )
  //        .retryer(Retryer.NEVER_RETRY);
  //  }

  @Bean
  public Request.Options options() {
    return new Request.Options(feignConnectTimeout, feignReadTimeout);
  }
}
