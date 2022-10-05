package org.rizki.mufrizal.belajar.cqrs.command.controller;

import org.rizki.mufrizal.belajar.cqrs.command.domain.Product;
import org.rizki.mufrizal.belajar.cqrs.command.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isEmpty()) {
            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("Success", false);
            stringObjectMap.put("Message", "Data Not Found");

            return new ResponseEntity<>(stringObjectMap, HttpStatus.NOT_FOUND);
        }
        product.setId(id);
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        Map<String, Object> stringObjectMap = new HashMap<>();
        if (optionalProduct.isEmpty()) {
            stringObjectMap.put("Success", false);
            stringObjectMap.put("Message", "Data Not Found");

            return new ResponseEntity<>(stringObjectMap, HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        stringObjectMap.put("Success", true);
        stringObjectMap.put("Message", "Data Dihapus");

        return new ResponseEntity<>(stringObjectMap, HttpStatus.NOT_FOUND);
    }

}