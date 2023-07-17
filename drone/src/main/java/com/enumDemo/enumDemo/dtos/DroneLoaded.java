package com.enumDemo.enumDemo.dtos;

import com.enumDemo.enumDemo.config.Medication;
import com.enumDemo.enumDemo.entities.Drone;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DroneLoaded {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Drone drone;
    private List<Medication> medication;


}
