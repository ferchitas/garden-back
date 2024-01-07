package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.ferchu.garden.implementation.mapper.CareMapperDaoToDto;
import org.ferchu.garden.implementation.repository.CareRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CareService implements CareServiceI {

    @Autowired
    CareRepository careRepository;

    @Override
    public Care createCare(Care care) {

        return null;
    }

    @Override
    public Void deleteCare(Care care) {
        return null;
    }

    @Override
    public List<Care> getAllCares() {

        CareMapperDaoToDto careMapperDaoToDto = Mappers.getMapper(CareMapperDaoToDto.class);

        List<CareDao> careResult = (List<CareDao>) careRepository.findAll();
        return careMapperDaoToDto.map(careResult);
    }

    @Override
    public Care updateCare(Care care) {
        return null;
    }
}
