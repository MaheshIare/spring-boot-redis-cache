/**
 * 
 */
package com.java.techhub.redis.demo.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author mahes
 *
 */
@Configuration
public class DefaultDataBean {
	
	@Value("${spring.boot.redis.host}")
	private String redisHost;
	
	@Value("${spring.boot.redis.username}")
	private String redisUsername;
	
	@Value("${spring.boot.redis.password}")
	private String redisPassword;
	
	@Value("${spring.boot.redis.port}")
	private Integer redisPort;
	
	@Value("${spring.boot.redis.client.timeout}")
	private Integer clientTimeout;

	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
		redisStandaloneConfiguration.setUsername(redisUsername);
		redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
		JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofSeconds(clientTimeout));
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        jedisConFactory.afterPropertiesSet();
        return jedisConFactory;
	}
}
