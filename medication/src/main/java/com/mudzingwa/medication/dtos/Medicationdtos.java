package com.mudzingwa.medication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicationdtos {
    private String name;
    private Long weight;
    private String code;
    private String image;

}
