package org.rizki.mufrizal.belajar.cqrs.command.repository;

import org.rizki.mufrizal.belajar.cqrs.command.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
