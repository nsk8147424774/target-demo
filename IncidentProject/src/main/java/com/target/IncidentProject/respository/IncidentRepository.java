package com.target.IncidentProject.respository;

import com.target.IncidentProject.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
