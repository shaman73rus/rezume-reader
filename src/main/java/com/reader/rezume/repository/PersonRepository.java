package com.reader.rezume.repository;

import com.reader.rezume.entity.PersonalData;

import java.util.Map;

/**
 * Repository for obtaining personal data
 *
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public interface PersonRepository {

    /**
     * Obtaining personal data from the storage
     * @return {@link PersonalData}
     */
    PersonalData getPersonalDataOfProperties();
}