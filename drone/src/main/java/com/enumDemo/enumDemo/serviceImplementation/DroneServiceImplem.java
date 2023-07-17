package com.enumDemo.enumDemo.serviceImplementation;

import com.enumDemo.enumDemo.config.DroneFeign;
import com.enumDemo.enumDemo.config.Medication;
import com.enumDemo.enumDemo.dtos.DroneLoaded;
import com.enumDemo.enumDemo.dtos.Dronedto;
import com.enumDemo.enumDemo.entities.Drone;
import com.enumDemo.enumDemo.exceptions.ResourceNotFoundException;
import com.enumDemo.enumDemo.repositories.DroneLoadedRepositories;
import com.enumDemo.enumDemo.repositories.DroneRepository;
import com.enumDemo.enumDemo.response.DroneRegisterResponse;
import com.enumDemo.enumDemo.response.DroneResponse;
import com.enumDemo.enumDemo.services.DroneServiceInterf;
import com.sun.source.tree.WhileLoopTree;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DroneServiceImplem implements DroneServiceInterf {
    private final DroneRepository droneRepository;
    private final DroneFeign droneFein;
    private final ModelMapper modelMapper;

    private final DroneLoadedRepositories droneLoadedRepositories;

    @Override
    public DroneRegisterResponse register(Dronedto dronedto) {
        Drone drone= modelMapper.map(dronedto,Drone.class);
        Drone drone1= droneRepository.save(drone);
        DroneRegisterResponse droneRegisterResponse= new DroneRegisterResponse();
        droneRegisterResponse.setDrone(drone1);
        droneRegisterResponse.setMsg("Drone with id"+drone1.getSerialNumber()+"successfully registered");
        return droneRegisterResponse;
    }

    @Override
    public DroneResponse loadDrone(Integer dronId, Integer medicationId) {
        Drone drone = droneRepository.findById(dronId).orElseThrow(()-> new ResourceNotFoundException("Drone","Drone id",dronId));
        Medication medication= droneFein.getMedication(medicationId);
        List<Medication> ls= new ArrayList<>();
        DroneResponse droneResponse= new DroneResponse();
        if (drone.getBatteryCapacity()>25 && drone.getWeight()<500){
          ls.add(medication);
          droneResponse.setDrone(drone);
         droneResponse.setMedication(ls);
         DroneLoaded droneLoaded= new DroneLoaded(dronId,drone,ls);
         droneLoadedRepositories.save(droneLoaded);
         droneResponse.setMessage("Drone Loaded successfully");
        }else
            return null;
        return droneResponse;
    }

    @Override
    public List<Drone> findAll() {
        List<Drone>droneList = droneRepository.findAll();
        return droneList;
    }

    @Override
    public DroneResponse findDronetoload(Integer integer) {
        droneLoadedRepositories.findById(integer).orElseThrow(()-> new ResourceNotFoundException("Drone","Drone id",integer));
        return null;
    }

    @Override
    public Drone findOne(Integer id) {
        return droneRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Drone","Drone id",id));
    }

    @Override
    public Integer droneCapicity(Integer id) {
        Drone drone= droneRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Drone","Drone id",id));
        Integer d = drone.getBatteryCapacity();
        return d;
    }

    @Override
    public List<Medication> findMedicationforDrone(Integer droneid) {
             return droneLoadedRepositories.findById(droneid).get().getMedication();
    }

    @Override
    public List<DroneLoaded> findAllAvailableforLoading() {
        List<DroneLoaded> loadedList = droneLoadedRepositories.findAll();
       List<DroneLoaded> droneLoadedList= loadedList.stream()
                                            .filter(drone->drone.getDrone().getWeight()<500)
                                            .collect(Collectors.toList());
        return droneLoadedList;
    }



}
