/*



        package com.frestonanalytics.msl.Employee;

import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import com.frestonanalytics.msl.Employee.service.EmployerService;
import com.frestonanalytics.msl.Employee.service.EmployerServiceImpli;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Slf4j
public class EmployerServiceTest {
    @Autowired
    private WebTestClient webTestClient;
    private final EmployerServiceImpli employerServiceImpli = mock(EmployerServiceImpli.class);
    private EmployerService employerService;


    @Test
    void createEmployer() {
        EmployerDto employerDto = EmployerDto.builder()
                .idCardNumber(12345)
                .userName("Arafath")
                .companyName("GHS")
                .build();

        EmployerEntity employerEntity = EmployerEntity.builder()
                .idCardNumber(12345)
                .userName("Arafath")
                .companyName("GHS")
                .build();

        when(employerServiceImpli.createEmployer(employerDto)).thenReturn(Mono.just(employerEntity));

        StepVerifier.create(employerService.createEmployer(employerDto))
                .expectNext(employerEntity)
                .verifyComplete();
    }


    @Test
    void getAllEmployers() {
        EmployerDto employerDto = EmployerDto.builder()
                .idCardNumber(1234567)
                .userName("Arafathkmss")
                .companyName("GHSi")
                .build();

        EmployerEntity employerEntity = EmployerEntity.builder()
                .idCardNumber(1234567)
                .userName("Arafathkmss")
                .companyName("GHSi")
                .build();

        when(employerService.gettingAll()).thenReturn(Flux.just(employerDto));

        StepVerifier.create(employerService.gettingAll())
                .expectNext(employerDto)
                .verifyComplete();

    }
}
*/