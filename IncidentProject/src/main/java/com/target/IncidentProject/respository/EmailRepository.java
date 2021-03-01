package com.target.IncidentProject.respository;

import com.target.IncidentProject.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email , Long> {
}
