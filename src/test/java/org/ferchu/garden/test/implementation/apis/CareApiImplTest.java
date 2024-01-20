package org.ferchu.garden.test.implementation.apis;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.generated.model.CareType;
import org.ferchu.garden.implementation.api.CareApiImpl;
import org.ferchu.garden.implementation.services.CareService;
import org.ferchu.garden.implementation.services.CareServiceI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class CareApiImplTest {

    @InjectMocks
    CareApiImpl careApiImpl;

    @Mock
    CareServiceI careService;

    List<Care> serviceResults;
    Care care;


    @BeforeEach
    public void setUp() {

        careService = Mockito.mock(CareService.class);
        serviceResults = new ArrayList<>();
        care = new Care();
        care.setId(BigDecimal.ONE);
        care.setApplicationDate(OffsetDateTime.now());
        care.setApplicationDuration(1L);
        CareType careType = new CareType();
        careType.setId(BigDecimal.ONE);
        careType.setName("name");
        careType.setDescription("description");
        care.setCareType(careType);
        serviceResults.add(care);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCareApiImplTest() {

        Mockito.when(careService.getAllCares()).thenReturn(serviceResults);
        ResponseEntity<List<Care>> result = careApiImpl.getAllCares();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getStatusCode().is2xxSuccessful());
        List<Care> cares = result.getBody();
        assert cares != null;
        Assertions.assertFalse(cares.isEmpty());
        Care care = cares.get(0);
        Assertions.assertNotNull(care.getId());
        Assertions.assertNotNull(care.getApplicationDate());
        Assertions.assertNotNull(care.getApplicationDuration());
        CareType careType = care.getCareType();
        Assertions.assertNotNull(careType);
        Assertions.assertNotNull(careType.getId());
        Assertions.assertNotNull(careType.getName());
        Assertions.assertNotNull(careType.getDescription());
    }

    @Test
    public void createCareApiTest() {

        Mockito.when(careService.createCare(Mockito.any())).thenReturn(care);
        ResponseEntity<Care> result = careApiImpl.createCare(care);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getStatusCode().is2xxSuccessful());
        Care careCreated = result.getBody();
        Assertions.assertNotNull(careCreated.getId());
        Assertions.assertNotNull(careCreated.getApplicationDate());
        Assertions.assertNotNull(careCreated.getApplicationDuration());
        CareType careTypeCreated = careCreated.getCareType();
        Assertions.assertNotNull(careTypeCreated);
        Assertions.assertNotNull(careTypeCreated.getId());
        Assertions.assertNotNull(careTypeCreated.getName());
        Assertions.assertNotNull(careTypeCreated.getDescription());
    }

    @Test
    public void updateCareCareApiTest() {

        Mockito.when(careService.updateCare(Mockito.any())).thenReturn(care);
        ResponseEntity<Care> result = careApiImpl.updateCare(care);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getStatusCode().is2xxSuccessful());
        Care careCreated = result.getBody();
        Assertions.assertNotNull(careCreated.getId());
        Assertions.assertNotNull(careCreated.getApplicationDate());
        Assertions.assertNotNull(careCreated.getApplicationDuration());
        CareType careTypeCreated = careCreated.getCareType();
        Assertions.assertNotNull(careTypeCreated);
        Assertions.assertNotNull(careTypeCreated.getId());
        Assertions.assertNotNull(careTypeCreated.getName());
        Assertions.assertNotNull(careTypeCreated.getDescription());
    }
}
