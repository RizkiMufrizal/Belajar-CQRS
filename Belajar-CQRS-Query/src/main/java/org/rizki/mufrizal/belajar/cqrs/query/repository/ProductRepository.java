package org.rizki.mufrizal.belajar.cqrs.query.repository;

import org.rizki.mufrizal.belajar.cqrs.query.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByNama(String nama);

    List<Product> findByNamaContaining(String nama);
}
