package com.enumDemo.enumDemo.response;

import com.enumDemo.enumDemo.entities.Drone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneRegisterResponse {
    private Drone drone;
    private String msg;
}
