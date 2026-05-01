package com.accenture.franchisemanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("products")
public class Product {
    @Id
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String name;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    @Column("branch_id")
    private Long branchId;
}