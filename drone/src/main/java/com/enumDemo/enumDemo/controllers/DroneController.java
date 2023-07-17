package com.enumDemo.enumDemo.controllers;

import com.enumDemo.enumDemo.config.Medication;
import com.enumDemo.enumDemo.dtos.DroneLoaded;
import com.enumDemo.enumDemo.dtos.Dronedto;
import com.enumDemo.enumDemo.entities.Drone;
import com.enumDemo.enumDemo.response.DroneRegisterResponse;
import com.enumDemo.enumDemo.response.DroneResponse;
import com.enumDemo.enumDemo.services.DroneServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableFeignClients
@RequestMapping("/drone")
@RequiredArgsConstructor
public class DroneController {
    private final DroneServiceInterf droneServiceInterf;
    @PostMapping("/register")
    public ResponseEntity<DroneRegisterResponse> registerDrone(@RequestBody Dronedto dronedto){
        return  new ResponseEntity<>(droneServiceInterf.register(dronedto), HttpStatus.CREATED);
    }
    @GetMapping("find-empty-forloading/{did}")
    public ResponseEntity<Drone> findToLoad(@PathVariable ("did") Integer id){
       return new ResponseEntity<>(droneServiceInterf.findOne(id),HttpStatus.OK);
    }
    @PostMapping("/load-drone/{did}/{medid}")
    public ResponseEntity<DroneResponse> loadDrone(@PathVariable("did") Integer did,@PathVariable("medid") Integer medid){
        return new ResponseEntity<>(droneServiceInterf.loadDrone(did,medid),HttpStatus.CREATED);
    }
    @GetMapping("/find-drone-capacity/{id}")
    public ResponseEntity<Integer> findCapacity(@PathVariable("id") Integer id){
        return new ResponseEntity<>(droneServiceInterf.droneCapicity(id),HttpStatus.OK);
    }
     @GetMapping("/find-medication-for Drone/{id}/")
    public ResponseEntity<List<Medication>> findMedication(@PathVariable("id") Integer id){
        return new ResponseEntity<>(droneServiceInterf.findMedicationforDrone(id),HttpStatus.FOUND);
    }
    @GetMapping("/find-not-fully-loaded")
    public ResponseEntity<List<DroneLoaded>> droneToload(){
        return new ResponseEntity<>(droneServiceInterf.findAllAvailableforLoading(),HttpStatus.OK);
    }
      @GetMapping("find-all-empty")
      public ResponseEntity<List<Drone>> findDrones(){
        return  new ResponseEntity<>(droneServiceInterf.findAll(),HttpStatus.OK);
      }
}
