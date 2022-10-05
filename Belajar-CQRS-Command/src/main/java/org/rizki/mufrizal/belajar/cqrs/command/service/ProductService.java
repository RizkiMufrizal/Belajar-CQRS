package org.rizki.mufrizal.belajar.cqrs.command.service;

import org.rizki.mufrizal.belajar.cqrs.command.domain.Product;

import java.util.Optional;

public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    void delete(String id);

    Optional<Product> findById(String id);
}
