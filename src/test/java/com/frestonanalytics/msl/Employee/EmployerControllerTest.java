package com.frestonanalytics.msl.Employee;
import com.frestonanalytics.msl.Employee.dto.EmployerDto;
import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import com.frestonanalytics.msl.Employee.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "36000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Employer Controller Test")
@AutoConfigureMockMvc(addFilters = false)
public class EmployerControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private EmployerService employerService;

    @Test
    @DisplayName("create Employer")
    void createEmployer()
    {
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

        when(employerService.createEmployer(employerDto)).thenReturn(Mono.just(employerEntity));

        webTestClient.post()
                .uri("/create")
                .body(Mono.just(employerDto),EmployerDto.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    @DisplayName("get all the Empoyer details")
    void getAllEmployers()
    {
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

      webTestClient
              .get()
              .uri("/getEmployers")
              .exchange()
              .expectStatus()
              .isOk();
    }

}