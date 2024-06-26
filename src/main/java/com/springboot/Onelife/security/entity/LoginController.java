package com.springboot.Onelife.security.entity;

import com.springboot.Onelife.security.entity.authority.Authority;
import com.springboot.Onelife.security.entity.authority.AuthorityRepository;
import com.springboot.Onelife.security.entity.customer.Customer;
import com.springboot.Onelife.security.entity.customer.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    private AuthorityRepository authorityRepository;

    public LoginController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;
        System.out.println(customer.getMobileNumber());
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
            savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
                String role ="ROLE_" +customer.getRole().toUpperCase();
                Authority auth = new Authority();
                auth.setCustomer(customer);
                auth.setName(role);
                authorityRepository.save(auth);


            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }

}
