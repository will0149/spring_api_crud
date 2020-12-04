package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.users.entities.User;
import com.example.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner {
	@Autowired
	private Faker faker;
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		if (repository.count() == 0) {
			for (int i = 0; i < 50; i++) {
				User user = new User();
				user.setUsername(faker.name().username());
				user.setPassword(faker.dragonBall().character());
				user.setProfile(null);
				user.setEmail(faker.name().username() + "@yopmail.com");
				repository.save(user);
			}
		}
	}

}
