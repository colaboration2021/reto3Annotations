package com.laurens.tul.model.repositories;

import com.laurens.tul.model.entities.Audience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudienceRepository extends JpaRepository<Audience, Integer> {
}
