package com.enumDemo.enumDemo.config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8090/medication",name = "medication")

public interface DroneFeign {

    @GetMapping("/find-medication/{id}")
    public Medication getMedication(@PathVariable("id") Integer id);
}
