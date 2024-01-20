package org.ferchu.garden.implementation.services;

import org.ferchu.garden.generated.model.Care;
import org.ferchu.garden.implementation.dao.CareDao;
import org.ferchu.garden.implementation.mapper.CareMapperDaoToDto;
import org.ferchu.garden.implementation.mapper.CareMapperDtoToDao;
import org.ferchu.garden.implementation.repository.CareRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareService implements CareServiceI {

    @Autowired
    CareRepository careRepository;

    CareMapperDtoToDao mapperDtoToDao = Mappers.getMapper(CareMapperDtoToDao.class);
    CareMapperDaoToDto mapperDaoToDto = Mappers.getMapper(CareMapperDaoToDto.class);


    @Override
    public Care createCare(Care care) {

        return mapperDaoToDto.transform(careRepository.save(mapperDtoToDao.transform(care)));
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

        CareDao careUpdated = null;

        if(careRepository.findById(care.getId().longValue()).isPresent()) {

            careUpdated = careRepository.save(mapperDtoToDao.transform(care));
        }
        return mapperDaoToDto.transform(careUpdated);
    }
}
