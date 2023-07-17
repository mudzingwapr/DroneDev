package com.mudzingwa.medication.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="medics")
public class Medication {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long weight;  
    private String code;
    private String image;
}
