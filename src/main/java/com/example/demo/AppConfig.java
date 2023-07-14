package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  @Qualifier("decoratedCreateOrderUseCase")
  public ICreateOrderUseCase decoratedCreateOrderUseCase(
      @Qualifier("plainCreateOrderUseCase") ICreateOrderUseCase createOrderUseCase) {
    System.out.println("in BEAN creation ");
    LoggingCreateOrderUseCase loggingCreateOrderUseCase =
        new LoggingCreateOrderUseCase(createOrderUseCase);
    DurationCreateOrderUseCase decoratedUseCase =
        new DurationCreateOrderUseCase(loggingCreateOrderUseCase);
    return decoratedUseCase;
  }
}
