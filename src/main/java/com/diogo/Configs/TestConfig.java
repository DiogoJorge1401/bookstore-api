package com.diogo.Configs;

import com.diogo.Services.DbServicesTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
  @Autowired
  private DbServicesTest dbServices;

  @Bean
  public void instanceDatabase() {
    this.dbServices.instanceDatabase();
  }
}