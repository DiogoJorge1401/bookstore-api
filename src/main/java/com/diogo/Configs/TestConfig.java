package com.diogo.Configs;

import com.diogo.Services.DbServicesTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("test")
public class TestConfig {
  @Autowired
  private DbServicesTest dbServices;

  @Bean
  public void instanceDatabase() {
    this.dbServices.instanceDatabase();
  }
  @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/categorys/save").allowedOrigins("http://localhost:4200");
			}
		};
	}
}