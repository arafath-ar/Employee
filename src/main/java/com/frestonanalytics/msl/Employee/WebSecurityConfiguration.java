///*
//package SpeingBootLearning.Employee;
//
//import SpeingBootLearning.Employee.service.EmployerService;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.security.Security;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration
//{
//
//     public PasswordEncoder passwordEncoder()
//     {
//         return new BCryptPasswordEncoder();
//     }
//
//
//    public EmployerService employerService()
//    {
//      UserDetails userDetails = User
//              .withUsername("Freston")
//              .password(passwordEncoder().encode("Freston@123"))
//              .roles("Normal get all method")
//              .build();
//   InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager(userDetails);
//   return inMemoryUserDetailsManager;
//    }
//
//     @Bean
//      public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception
//      {
//
//          httpSecurity.csrf().disable()
//                  .authorizeHttpRequests()
//                  .requestMatchers("/getEmployers")
//                  .permitAll()
//                  .anyRequest()
//                  .authenticated()
//                  .and()
//                  .formLogin();
//
//                  return httpSecurity.build();
//
//      }
//    }
//