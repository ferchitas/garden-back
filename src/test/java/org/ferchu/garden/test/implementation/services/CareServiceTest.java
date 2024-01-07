package org.ferchu.garden.test.implementation.services;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.api.CareApiImpl;
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
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class CareServiceTest {

    @InjectMocks
    CareService careService;

    @Mock
    CareRepository careRepository;

    List<CareDao> repositoryResult;

    @BeforeEach
    public void setUp() {

        careRepository = Mockito.mock(CareRepository.class);
        repositoryResult = new ArrayList<>();
        repositoryResult.add(
                CareDao.builder()
                        .id(1L)
                        .applicationDate(ZonedDateTime.now())
                        .applicationDurationRange(Duration.ofDays(1))
                        .careTypeDao(
                    CareTypeDao.builder()
                            .name("name")
                            .description("description")
                            .build())
                        .build());
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCareApiImplTest() {

        Mockito.when(careRepository.findAll()).thenReturn(repositoryResult);
        List<Care> result = careService.getAllCares();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Care care = result.get(0);
        Assertions.assertNotNull(care.getId());
    }
}
