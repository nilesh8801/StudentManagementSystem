package com.example.studentbootmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com/example/studentbootmongo"})
//@EnableMongoRepositories("com/example/studentbootmongo/repository")
public class StudentbootmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentbootmongoApplication.class, args);
	}

}
