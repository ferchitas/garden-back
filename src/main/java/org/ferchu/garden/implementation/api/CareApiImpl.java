package org.ferchu.garden.implementation.api;

import org.ferchu.garden.generated.api.CareApiDelegate;
import org.ferchu.garden.generated.model.Care;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CareApiImpl implements CareApiDelegate {

    @Override
    public ResponseEntity<Care> createCare(Care care) {

        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCare(Care care) {
        return null;
    }

    @Override
    public ResponseEntity<List<Care>> getAllCares() {
        return null;
    }

    @Override
    public ResponseEntity<Care> updateCare(Care care) {
            return null;
    }
}
