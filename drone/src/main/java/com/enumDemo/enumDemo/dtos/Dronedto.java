package com.enumDemo.enumDemo.dtos;

import com.enumDemo.enumDemo.config.Model;
import com.enumDemo.enumDemo.config.State;

public record Dronedto(Model model,
                       String colour, Double weight,
                       Integer batteryCapacity, State state) {
}
