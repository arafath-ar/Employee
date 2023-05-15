package com.frestonanalytics.msl.Employee.dtoConverter;


import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployEntityToDtoConvert implements Converterr<EmployerDto, EmployerEntity>
{
    public EmployerDto convert(EmployerEntity employerEntity)
    {
        return EmployerDto.builder()
                .companyName(employerEntity.getCompanyName())
                .idCardNumber(employerEntity.getIdCardNumber())
                .userName(employerEntity.getUserName())
                .build();
    }
}