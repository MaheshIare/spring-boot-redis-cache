# spring-boot-redis-cache

This is a simple spring application developed using Spring boot to demonstrate the integration of swagger for API documentation and **[Redis cache](https://redis.io/topics/introduction)** for caching the data. 

## Build

```bash
mvn clean install
```

## Prerequisites
**This application requires Redis setup.**
You can download redis setup from here **[Redis-3.0.504](https://github.com/microsoftarchive/redis/releases/tag/win-3.0.504)**. Once downloaded, extract into your local machine. Navigate to the extracted folder and run the below commands using command line.

To run the redis server

```bash
redis-server.exe
```
To run the redis cli

```bash
redis-cli.exe
```

## Instructions

Add below dependencies to your pom.xml

```java
		<!-- Redis starter dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		
		<!-- Redis client dependency -->
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<type>jar</type>
		</dependency>
```
Add below configuration into your application.properties file

```bash

### Redis cache configuration ###
spring.cache.type=redis
spring.boot.redis.host=localhost
spring.boot.redis.port=6379
spring.boot.redis.client.timeout=60
spring.boot.redis.username=test
spring.boot.redis.password=test
spring.cache.redis.time-to-live=300000

```

Once the application is up and running, we can simply access below links for swagger UI and API docs and see the Redis caching in action.

[Swagger UI](http://localhost:8080/spring-boot-redis-cache/swagger-ui/)

[Swagger-Docs](http://localhost:8080/spring-boot-redis-cache/v2-docs/)

## More information
I have used below annotations for demonstrating the redis caching operations

```bash

@EnableCaching - This annotation is for enabling the spring caching backed-up by Redis

@CachePut – This annotation is used to update the cache.

@Cacheable – This annotation indicates that the result of calling a method can be cached.

@CacheEvict – This annotation is used to remove the data from cache.

```

## Questions
If you have project related questions please create a ticket with your question here [Create Issue](https://github.com/MaheshIare/spring-boot-redis-cache/issues)


## Author

**Mahesh Kumar Gutam**

* [Github](https://github.com/MaheshIare)

## Feedback
Please feel free to send me some feedback or questions!