package org.rizki.mufrizal.belajar.cqrs.kafka.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMapper implements Serializable {
    private String id;

    private String nama;

    private Integer jumlah;

    private BigDecimal harga;
}
