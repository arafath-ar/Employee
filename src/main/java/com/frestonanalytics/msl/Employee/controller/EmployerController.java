package com.frestonanalytics.msl.Employee.controller;


import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import com.frestonanalytics.msl.Employee.service.EmployerService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@RestController
public class EmployerController
{
    @Autowired private EmployerService employerService;
    @Autowired
    private EmployerDto employerDto;

 @PostMapping("/create")
 @ResponseStatus(HttpStatus.CREATED)
 public Mono<EmployerEntity> createEmployer(@RequestBody @NonNull EmployerDto employerDto) {
    return employerService.createEmployer(employerDto);
}

 @GetMapping("/getEmployers")
 public Flux<EmployerDto> gettingAll()
    {

        return employerService.gettingAll();
    }
 @GetMapping("/getid/{idCardNumber}")
    public Mono<EmployerDto> getById(@PathVariable("idCardNumber") int idCardNumber)
{
    return employerService.getById(idCardNumber);
}

@PutMapping("/update/{idCardNumber}")
    public Mono<EmployerDto> updateEmployer(@RequestBody EmployerDto employerDto)
    {
     return employerService.updateEmployer(employerDto);
}

 @DeleteMapping("/delete/{idCardNumber}")
    public Mono<Void> deleteEmployer(@PathVariable("idCardNumber") int idCardNumber)
{
    return employerService.deleteEmployer(idCardNumber);
}
}