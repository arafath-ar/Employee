package com.frestonanalytics.msl.Employee.dtoConverter;

import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import org.springframework.stereotype.Component;

@Component
public class DtoToEmployEntityConverter implements Converterr<EmployerEntity, EmployerDto>
{
    public EmployerEntity convert(EmployerDto employerDto)
    {
    return EmployerEntity.builder()
            .idCardNumber(employerDto.getIdCardNumber())
            .companyName(employerDto.getCompanyName())
            .userName(employerDto.getUserName())
            .build();

    }
}