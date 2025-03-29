package com.example.OrderService.feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import static java.util.concurrent.TimeUnit.SECONDS;

public class FeignRetryConfig {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 3);
    }
}
