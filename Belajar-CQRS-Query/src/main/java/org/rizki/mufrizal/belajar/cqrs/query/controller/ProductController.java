package org.rizki.mufrizal.belajar.cqrs.query.controller;

import org.rizki.mufrizal.belajar.cqrs.query.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public ResponseEntity<?> findProductByNama(@RequestParam("nama") String nama) {
        return new ResponseEntity<>(productService.findByNama(nama), HttpStatus.OK);
    }

    @GetMapping(value = "/contain/product")
    public ResponseEntity<?> findProductContainNama(@RequestParam("nama") String nama) {
        return new ResponseEntity<>(productService.findByNamaContaining(nama), HttpStatus.OK);
    }

}