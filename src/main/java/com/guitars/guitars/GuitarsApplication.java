package com.guitars.guitars;

import com.guitars.guitars.guitar.GuitarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GuitarsApplication implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(GuitarsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GuitarsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("You're awesome!");
	}
}
