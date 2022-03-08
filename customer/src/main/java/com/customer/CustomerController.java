package com.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public  String registerCustomer(@RequestBody CustomerRegistrationRequstDTO customerRegistrationRequstDTO){
        log.info("new Customer registration {}", customerRegistrationRequstDTO);
        customerService.registerCustomer(customerRegistrationRequstDTO);
        return "created";
    }

    @GetMapping
    public List<CustomerRegistrationRequstDTO> getAllCustomer(){
        log.info("get All Customers");
       return customerService.getllCustomers();
    }
}
