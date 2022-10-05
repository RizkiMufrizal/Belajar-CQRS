package org.rizki.mufrizal.belajar.cqrs.query.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(indexName = "product_index")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String nama;

    @Field(type = FieldType.Integer, name = "jumlah")
    private Integer jumlah;

    @Field(type = FieldType.Double, name = "harga")
    private BigDecimal harga;
}
