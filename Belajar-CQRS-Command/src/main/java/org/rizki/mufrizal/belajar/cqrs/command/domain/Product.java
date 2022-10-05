package org.rizki.mufrizal.belajar.cqrs.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private String id;

    private String nama;

    private Integer jumlah;

    private BigDecimal harga;
}