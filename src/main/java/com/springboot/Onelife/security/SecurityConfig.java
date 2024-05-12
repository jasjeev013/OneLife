package com.springboot.Onelife.security;

import com.springboot.Onelife.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import java.util.Collections;

@RestController
public class SecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http.securityContext((context) -> context
                        .requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                })).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/hospitals","/hospitals/{id}","/hospitals","/hospitals/findByName/{id}",
                                "/hospitals/findByAddress/{id}","/hospitals/delete/{id}")
                        .hasRole("OWNER")

                        .requestMatchers("/hospitals/{id}/departments","/hospitals/{id}/departments/{dept_id}",
                                "/hospitals/{id}/departments/filterByName/{name}","/hospitals/{id}")
                        .hasAnyRole("OWNER","ADMIN")

                        .requestMatchers("/hospitals/{hospId}/doctors","/hospitals/{hospId}/departments/{deptId}/doctors",
                                "/hospitals/{hospId}/departments/{id}/doctors","/hospitals/{hospId}/departments/{deptId}/doctorsbyname/{docName}",
                                "/hospitals/{hospId}/doctors/{docId}","/hospitals/{hospId}/staff","/hospitals/{hospid}/departments/{deptid}/staff",
                                "/hospitals/{hospId}/staff/{staffId}","/hospitals/{hospId}/departments/{id}/staffbyname/{staffName}",
                                "/hospitals/{hospId}/departments/{id}/staff", "/hospitals/{hospId}/staff/{staffId}")
                        .hasAnyRole("ADMIN","MANAGER")

                        .requestMatchers("/hospitals/{hospId}/patients","/hospitals/{hospId}/pharmacy/{pharmacyId}/patients",
                                "/hospitals/{hospId}/patients/{patientId}","/hospitals/{hospId}/patients/{patientId}",
                                "hospitals/{hospitalId}/pharmacies","/hospitals/{hospitalId}/pharmacies/{pharmId}",
                                "/hospitals/{hospitalId}/pharmacy","/hospitals/{hospitalId}/pharmacy/{pharmId}",
                                "/hospital/{hospitalId}/pharmacy/{pharmacyId}","hospital/{hospitalId}/patients/{patientId}/invoices",
                                "/hospital/{hospitalId}/patients/{patientId}/invoices","/hospital/{hospitalId}/invoices/{invoiceId}",
                                "/hospital/{hospitalId}/invoices/{invoiceId}","hospitals/{hospitalId}/patients/{patientId}/prescriptions",
                                "/hospitals/{hospitalId}/patients/{patientId}/prescriptions","/hospital/{hospitalId}/prescriptions/{prescriptionId}",
                                "/hospitals/{hospitalId}/prescriptions/{prescriptionId}","/hospitals/{hospId}/doctors/{docId}/appointments",
                                "hospital/{hospId}/patient/{patientId}/appointments/{doctorId}","/hospitals/{hospId}/doctors/{docId}/patients/{patientId}",
                                "hospital/{hospitalId}/doctor/{doctorId}/patient/{patientId}","/hospital/{hospitalId}/doctors/{doctorId}/patients/{patientId}")
                        .hasAnyRole("MANAGER","RECEPTIONIST")

                        .requestMatchers("/hospitals/{hospitalId}/patients/{patientId}/invoices/{invoiceId}",
                                "/hospitals/{hospitalId}/prescriptions/{prescriptionId}","/hospitals/{hospId}/appointments/{patientId}").permitAll()
                        .requestMatchers("/contact","/register").permitAll()

                        .requestMatchers( "/hospitals/**").authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .antMatchers("/hospitals","/register","/contact").permitAll()
//                .antMatchers("/hospitals/**").authenticated()
//                .and().formLogin()
//                .and().httpBasic();
//        System.out.println("hello");
//        return http.build();
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
