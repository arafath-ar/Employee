package com.frestonanalytics.msl.Employee.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployerDto
{
    private int idCardNumber;
    private String userName;
    private String companyName;

}