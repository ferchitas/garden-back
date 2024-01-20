package org.ferchu.garden.implementation.api;

import org.ferchu.garden.generated.api.CareApiDelegate;
import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.ferchu.garden.implementation.services.CareService;
import org.ferchu.garden.implementation.services.CareServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CareApiImpl implements CareApiDelegate {

    @Autowired
    CareServiceI careService;

    @Override
    public ResponseEntity<Care> createCare(Care care) {

        return ResponseEntity.ok(careService.createCare(care));
    }

    @Override
    public ResponseEntity<Void> deleteCare(Care care) {
        return null;
    }

    @Override
    public ResponseEntity<List<Care>> getAllCares() {

        return ResponseEntity.ok(careService.getAllCares());
    }

    @Override
    public ResponseEntity<Care> updateCare(Care care) {

        return ResponseEntity.ok(careService.updateCare(care));
    }
}
