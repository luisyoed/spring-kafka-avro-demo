package com.curso.avro.kafka.spkafkaavrodemo.producer;

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
				System.out.println("Message failed to produce");
			}

			@Override
			public void onSuccess(SendResult<String, StockHistory> result) {
				System.out.println("Avro message successfully produced");
			}
		});

	}

}
