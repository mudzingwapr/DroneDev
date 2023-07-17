package com.enumDemo.enumDemo.services;

import com.enumDemo.enumDemo.config.Medication;
import com.enumDemo.enumDemo.dtos.DroneLoaded;
import com.enumDemo.enumDemo.dtos.Dronedto;
import com.enumDemo.enumDemo.entities.Drone;
import com.enumDemo.enumDemo.response.DroneRegisterResponse;
import com.enumDemo.enumDemo.response.DroneResponse;

import java.util.List;

public interface DroneServiceInterf {
    public DroneRegisterResponse register(Dronedto dronedto);
    public DroneResponse loadDrone(Integer dronId,Integer medicationId);
    public List<Drone> findAll();
    public DroneResponse findDronetoload(Integer integer);
    public Drone findOne(Integer id);
    public Integer droneCapicity(Integer id);
    public List<Medication> findMedicationforDrone(Integer droneid);
    public List<DroneLoaded> findAllAvailableforLoading();

}
