package org.rizki.mufrizal.belajar.cqrs.query.service.impl;

import org.rizki.mufrizal.belajar.cqrs.query.domain.Product;
import org.rizki.mufrizal.belajar.cqrs.query.repository.ProductRepository;
import org.rizki.mufrizal.belajar.cqrs.query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findByNama(String nama) {
        return productRepository.findByNama(nama);
    }

    @Override
    public List<Product> findByNamaContaining(String nama) {
        return productRepository.findByNamaContaining(nama);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}