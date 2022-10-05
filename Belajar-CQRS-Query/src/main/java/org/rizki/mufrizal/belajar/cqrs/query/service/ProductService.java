package org.rizki.mufrizal.belajar.cqrs.query.service;

import org.rizki.mufrizal.belajar.cqrs.query.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByNama(String nama);

    List<Product> findByNamaContaining(String nama);

    Product save(Product product);
}
