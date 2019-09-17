package com.wander;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wander.manifold.**.mapper")
public class ManifoldKnowledgeCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManifoldKnowledgeCommunityApplication.class, args);
	}

}
