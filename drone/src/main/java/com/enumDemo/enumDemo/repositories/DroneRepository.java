package com.enumDemo.enumDemo.repositories;

import com.enumDemo.enumDemo.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone,Integer> {
}
