package com.enumDemo.enumDemo.response;

import com.enumDemo.enumDemo.config.Medication;
import com.enumDemo.enumDemo.entities.Drone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneResponse {
    private Drone drone;
    private List<Medication> medication;
    private String message;
}
