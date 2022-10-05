package org.rizki.mufrizal.belajar.cqrs.command.service.impl;

import org.rizki.mufrizal.belajar.cqrs.command.domain.Product;
import org.rizki.mufrizal.belajar.cqrs.command.kafka.producer.ProductProducer;
import org.rizki.mufrizal.belajar.cqrs.command.repository.ProductRepository;
import org.rizki.mufrizal.belajar.cqrs.command.service.ProductService;
import org.rizki.mufrizal.belajar.cqrs.kafka.object.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductProducer productProducer;

    @Override
    public Product save(Product product) {
        ProductMapper productMapper = new ProductMapper();
        productMapper.setId(product.getId());
        productMapper.setNama(product.getNama());
        productMapper.setHarga(product.getHarga());
        productMapper.setJumlah(product.getJumlah());

        productProducer.sendProduct("product", product.getId(), productMapper);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }
}