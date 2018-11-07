package com.alan.api;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;
import static com.alan.api.core.ProjectConstant.MAPPER_PACKAGE;


@EnableEncryptableProperties
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = MAPPER_PACKAGE)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
