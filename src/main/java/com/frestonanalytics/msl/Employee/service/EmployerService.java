package com.frestonanalytics.msl.Employee.service;

import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.dtoConverter.DtoToEmployEntityConverter;
import com.frestonanalytics.msl.Employee.dtoConverter.EmployEntityToDtoConvert;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EmployerService
{
        @Autowired
        EmployerServiceImpli employerServiceImpli;
        @Autowired
        EmployEntityToDtoConvert employEntityToDtoConvert;
        @Autowired
        DtoToEmployEntityConverter dtoToEmployEntityConverter;

    public Mono<EmployerEntity> createEmployer(EmployerDto employerDto) {
        return employerServiceImpli
                .createEmployer(employerDto);

    }

    public Flux<EmployerDto> gettingAll() {
            return employerServiceImpli.gettingAll()
                    .map(employEntityToDtoConvert::convert);

    }

    public Mono<EmployerDto> getById(int idCardNumber) {
        return employerServiceImpli.getById(idCardNumber);
    }

    public Mono<EmployerDto> updateEmployer(EmployerDto employerDto) {
            return employerServiceImpli
                    .updateEmployer(dtoToEmployEntityConverter.convert(employerDto))
                    .map(employEntityToDtoConvert::convert);
    }

    public Mono<Void> deleteEmployer(int idCardNumber) {
            return employerServiceImpli
                    .deleteEmployer(idCardNumber)
                    .then();
    }
}