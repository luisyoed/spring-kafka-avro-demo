package com.curso.avro.kafka.spkafkaavrodemo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.curso.avro.kafka.spkafkaavrodemo.schema.StockHistory;

@Service
public class SpAvroProducer {
	static final Logger log = LoggerFactory.getLogger(SpAvroProducer.class);
	
	@Value("${avro.topic.name}")
	String topicName;

	@Autowired
	private KafkaTemplate<String, StockHistory> kafkaTemplate;

	public void send(StockHistory stockHistory) {

		ListenableFuture<SendResult<String, StockHistory>> future = kafkaTemplate.send(topicName,
				String.valueOf(stockHistory.getStudentId()), stockHistory);
		future.addCallback(new ListenableFutureCallback<SendResult<String, StockHistory>>() {
			@Override
			public void onFailure(Throwable ex) {
				log.info("Message failed to produce");
				log.info("Fin de producer");
			}

			@Override
			public void onSuccess(SendResult<String, StockHistory> result) {
				log.info("Avro message successfully produced");
				log.info("Fin de producer");
			}
		});

	}

}
