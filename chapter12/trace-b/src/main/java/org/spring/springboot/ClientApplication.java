package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Spring Boot 应用启动类
 */
// Spring Boot 应用的标识
@RestController
@SpringBootApplication
public class ClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@GetMapping("/trace-b")
	public Mono<String> trace() {
		System.out.println("===call trace-b===");

		return Mono.just("Trace");
	}

}