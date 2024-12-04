package com.travelport.democacheredis.config;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@EnableCaching
@Configuration
public class CacheConfiguration {
/*
  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
    return RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(10)) // Set TTL to 10 minutes
        .disableCachingNullValues();
  }
*/
}
