package com.frestonanalytics.msl.Employee.service;

import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.dtoConverter.DtoToEmployEntityConverter;
import com.frestonanalytics.msl.Employee.dtoConverter.EmployEntityToDtoConvert;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import com.frestonanalytics.msl.Employee.repository.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Slf4j
public class EmployerServiceImpli{

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    DtoToEmployEntityConverter dtoToEmployEntityConverter;
    @Autowired
    EmployEntityToDtoConvert employEntityToDtoConvert;

    public Mono<EmployerEntity> createEmployer(EmployerDto employerDto)
    {
        return Mono.just(employerRepository.save(dtoToEmployEntityConverter.convert(employerDto)));
    }

    public Flux<EmployerEntity> gettingAll()
    {

        return Flux.fromIterable(employerRepository.findAll());
                //.map(employEntityToDtoConvert::convert);
    }

    public Mono<EmployerDto> getById(int idCardNumber)
    {
        Optional<EmployerEntity> a=employerRepository.findById(idCardNumber);
        return a.map(employerEntity -> Mono.justOrEmpty(employEntityToDtoConvert.convert(employerEntity))).orElse(null);
    }

    public Mono<EmployerEntity> updateEmployer(EmployerEntity employerEntity)
    {
        Optional<EmployerEntity> employers=employerRepository.findById(employerEntity.getIdCardNumber());

        if (employers.isPresent())
        {
            EmployerEntity employerEntity1 = employers.get();
            employerEntity1.setCompanyName(employerEntity.getCompanyName());
            employerEntity1.setUserName(employerEntity.getUserName());
          //  employerEntity1.getIdCardNumber(employerEntity.getIdCardNumber());
            return Mono.just(employerRepository.save(employerEntity1));
        }
            else
            {
                return null;
            }
    }

    public Mono<Void> deleteEmployer(int idCardNumber)
    {
        Optional<EmployerEntity> id=employerRepository.findById(idCardNumber);
        if(id.isPresent())
        {
            employerRepository.deleteById(id.get().getIdCardNumber());
            return Mono.just("Deleted Successfully").then();
        }
        else
        {
            return Mono.empty();
        }
    }
}