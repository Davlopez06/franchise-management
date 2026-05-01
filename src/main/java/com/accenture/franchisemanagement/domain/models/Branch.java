package com.accenture.franchisemanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("branches")
public class Branch {
    @Id
    private Long id;
    private String name;
    
    @Column("franchise_id")
    private Long franchiseId;
}
