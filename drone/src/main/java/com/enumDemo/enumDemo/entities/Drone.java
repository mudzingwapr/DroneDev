package com.enumDemo.enumDemo.entities;

import com.enumDemo.enumDemo.config.Model;
import com.enumDemo.enumDemo.config.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serialNumber;
    private Model model;
    private Double weight;
    private Integer batteryCapacity;
    private State state;

}
