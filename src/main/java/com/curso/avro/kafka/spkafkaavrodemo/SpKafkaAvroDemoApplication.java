package com.curso.avro.kafka.spkafkaavrodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpKafkaAvroDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpKafkaAvroDemoApplication.class, args);
	}

}
