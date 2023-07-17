package com.mudzingwa.medication.repositories;

import com.mudzingwa.medication.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Medicationrepository extends JpaRepository<Medication,Integer> {
}
