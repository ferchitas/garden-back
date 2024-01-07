package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Care;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CareServiceI {

    public Care createCare(Care care);
    public Void deleteCare(Care care);
    public List<Care> getAllCares();
    public Care updateCare(Care care);
}
