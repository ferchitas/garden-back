package org.ferchu.garden.test.implementation.services;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.generated.model.CareType;
import org.ferchu.garden.implementation.dao.CareDao;
import org.ferchu.garden.implementation.dao.CareTypeDao;
import org.ferchu.garden.implementation.repository.CareRepository;
import org.ferchu.garden.implementation.services.CareService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CareServiceTest {

    @InjectMocks
    CareService careService;

    @Mock
    CareRepository careRepository;

    List<CareDao> repositoryCaresResult;

    CareDao repositoryCareResult;
    Care care;


    @BeforeEach
    public void setUp() {

        careRepository = Mockito.mock(CareRepository.class);
        repositoryCaresResult = new ArrayList<>();
        repositoryCareResult = CareDao.builder()
                .id(1L)
                .applicationDate(OffsetDateTime.now())
                .applicationDurationRange(Duration.ofDays(1))
                .careTypeDao(
                        CareTypeDao.builder()
                                .id(1L)
                                .name("name")
                                .description("description")
                                .build())
                .build();
        repositoryCaresResult.add(repositoryCareResult);

        care = new Care();
        care.setId(BigDecimal.ONE);
        care.setApplicationDate(OffsetDateTime.now());
        care.setApplicationDuration(1L);
        CareType careType = new CareType();
        careType.setId(BigDecimal.ONE);
        careType.setName("name");
        careType.setDescription("description");
        care.setCareType(careType);

        MockitoAnnotations.openMocks(this);
        Duration d = Duration.ofDays(1);
    }

    @Test
    public void getCaresTest() {

        Mockito.when(careRepository.findAll()).thenReturn(repositoryCaresResult);
        List<Care> result = careService.getAllCares();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Care care = result.get(0);
        Assertions.assertNotNull(care.getId());
        Assertions.assertNotNull(care.getApplicationDate());
        Assertions.assertNotNull(care.getApplicationDuration());
        Assertions.assertTrue(care.getApplicationDuration() > 0);
        CareType careType = care.getCareType();
        Assertions.assertNotNull(care.getCareType());
        Assertions.assertNotNull(careType.getId());
        Assertions.assertNotNull(careType.getName());
        Assertions.assertNotNull(careType.getDescription());
    }

    @Test
    public void createCare() {

        Mockito.when(careRepository.save(Mockito.any())).thenReturn(repositoryCareResult);
        Care result = careService.createCare(care);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertNotNull(result.getApplicationDate());
        Assertions.assertNotNull(result.getApplicationDuration());
        Assertions.assertTrue(result.getApplicationDuration() > 0);
        CareType careType = result.getCareType();
        Assertions.assertNotNull(result.getCareType());
        Assertions.assertNotNull(careType.getId());
        Assertions.assertNotNull(careType.getName());
        Assertions.assertNotNull(careType.getDescription());
    }

    @Test
    public void updateCare() {

        Mockito.when(careRepository.findById(Mockito.any())).thenReturn(Optional.of(repositoryCareResult));
        Mockito.when(careRepository.save(Mockito.any())).thenReturn(repositoryCareResult);
        Care result = careService.updateCare(care);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertNotNull(result.getApplicationDate());
        Assertions.assertNotNull(result.getApplicationDuration());
        Assertions.assertTrue(result.getApplicationDuration() > 0);
        CareType careType = result.getCareType();
        Assertions.assertNotNull(result.getCareType());
        Assertions.assertNotNull(careType.getId());
        Assertions.assertNotNull(careType.getName());
        Assertions.assertNotNull(careType.getDescription());
    }
}
