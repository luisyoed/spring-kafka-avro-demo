package com.curso.avro.kafka.spkafkaavrodemo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.curso.avro.kafka.spkafkaavrodemo.schema.StockHistory;



@Service
public class SpAvroConsumer {
	
	static final Logger log = LoggerFactory.getLogger(SpAvroConsumer.class);

	 @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
	    public void read(ConsumerRecord<String, StockHistory> record){
		 	log.info("inicia de Consumer");
	        String key=record.key();
	        StockHistory history=record.value();
	        log.info("Avro message received for key: {}  value: {}",key,history.toString());
	        log.info("Fin de Consumer");
	 }

}
