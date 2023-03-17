package com.bsf.unleashdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Expense {
    @Id
    private String id;
    private LocalDate date;
    private String description;
    private BigDecimal amount;
}
