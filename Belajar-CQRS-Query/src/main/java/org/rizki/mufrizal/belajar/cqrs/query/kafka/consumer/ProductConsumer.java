package org.rizki.mufrizal.belajar.cqrs.query.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.rizki.mufrizal.belajar.cqrs.kafka.object.ProductMapper;
import org.rizki.mufrizal.belajar.cqrs.query.domain.Product;
import org.rizki.mufrizal.belajar.cqrs.query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductConsumer {

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "product", groupId = "cqrs-group")
    public void consumeJson(ProductMapper productMapper) {
        log.info("product mapper log {}", productMapper);

        Product product = new Product();
        product.setId(productMapper.getId());
        product.setNama(productMapper.getNama());
        product.setHarga(productMapper.getHarga());
        product.setJumlah(productMapper.getJumlah());

        log.info("product log {}", product);

        productService.save(product);
    }

}