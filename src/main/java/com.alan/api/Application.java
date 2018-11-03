package com.alan.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;
import static com.alan.api.core.ProjectConstant.MAPPER_PACKAGE;

@SpringBootApplication
@MapperScan(basePackages = MAPPER_PACKAGE)
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
