package com.curso.avro.kafka.spkafkaavrodemo.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.avro.kafka.spkafkaavrodemo.model.StockHistoryModel;
import com.curso.avro.kafka.spkafkaavrodemo.producer.SpAvroProducer;
import com.curso.avro.kafka.spkafkaavrodemo.schema.StockHistory;


@RestController
@RequestMapping("/producer")
public class SpAvroRestController {

static final Logger log = LoggerFactory.getLogger(SpAvroRestController.class);
	
	@Autowired
	SpAvroProducer spAvroProducer;
	
	@PostMapping(value = "/publishMessage", consumes = MediaType.APPLICATION_JSON_VALUE,  produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> seandMessage(@RequestBody StockHistoryModel request){
		log.info("inicia de servicio");
		StockHistory stockHistory= StockHistory.newBuilder().build();
		stockHistory.setStudentId(new Random(1000).nextInt());
		stockHistory.setRegistrationNumber(request.getRegistrationNumber());
		stockHistory.setCity(request.getCity());
		stockHistory.setName(request.getName());
		stockHistory.setLastName(request.getLastName());
		stockHistory.setTuitionCost(request.getTuitionCost());
		stockHistory.setMonthlyPayment(request.getMonthlyPayment());
		spAvroProducer.send(stockHistory);
		log.info("Fin de servicio");
		
		return new ResponseEntity<>(request.getName() + " " + request.getLastName() + " publicado", HttpStatus.OK);
		
	}

}
