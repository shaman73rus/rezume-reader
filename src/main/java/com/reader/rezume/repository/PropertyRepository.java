package com.reader.rezume.repository;

import com.reader.rezume.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PersonalData, Long> {
}
