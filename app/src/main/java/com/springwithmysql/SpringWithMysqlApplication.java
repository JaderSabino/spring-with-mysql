package com.springwithmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWithMysqlApplication implements CommandLineRunner {

	@Autowired
	private ConfigInterface configInterface;

	public static void main(String[] args) {
		SpringApplication.run(SpringWithMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configInterface.run();
	}
}
