package org.rizki.mufrizal.belajar.cqrs.command.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.rizki.mufrizal.belajar.cqrs.kafka.object.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class ProductProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendProduct(String topic, String key, ProductMapper productMapper) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, productMapper);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(final SendResult<String, Object> message) {
                log.info("sent message : {}, with topic : {}, with offset : {}, with partition : {}, with timestamp {}",
                        message.getProducerRecord().value(), topic, message.getRecordMetadata().offset(), message.getRecordMetadata().partition(), message.getRecordMetadata().timestamp());
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("unable to send message", throwable);
            }
        });
    }

}