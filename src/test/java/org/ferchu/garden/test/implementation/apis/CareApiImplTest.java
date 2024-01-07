package org.ferchu.garden.test.implementation.apis;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.api.CareApiImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CareApiImplTest {

    @InjectMocks
    CareApiImpl careApiImpl;

    @Test
    public void getCareApiImplTest() {

        ResponseEntity<List<Care>> result = careApiImpl.getAllCares();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getStatusCode().is2xxSuccessful());
        List<Care> cares = result.getBody();
        assert cares != null;
        Assertions.assertFalse(cares.isEmpty());
        Care care = cares.get(0);
        Assertions.assertNotNull(care.getId());
        Assertions.assertNotNull(care.getName());
    }
}
