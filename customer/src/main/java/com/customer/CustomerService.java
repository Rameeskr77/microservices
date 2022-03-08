package com.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

   private final CustomerRepository customerRepository;
   private  final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequstDTO customerRegistrationRequstDTO) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequstDTO.getFirstName())
                .lastName(customerRegistrationRequstDTO.getLastName())
                .email(customerRegistrationRequstDTO.getEmail())
                .build();

        customerRepository.save(customer);
        FraudCheckResponce fraudCheckRespose = restTemplate.getForObject("http://FRAUD/api/fraud-check/{customerId}", FraudCheckResponce.class, customer.getId());
        if (fraudCheckRespose.isFraud()){
            throw new IllegalArgumentException("is fraud Customer");
        }

    }

    public List<CustomerRegistrationRequstDTO> getllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerRegistrationRequstDTO> customerRegistrationRequstDTOS = new ArrayList<>();
        customers.forEach(data ->{
            CustomerRegistrationRequstDTO customerRegistrationRequstDTO = CustomerRegistrationRequstDTO.builder()
                    .firstName(data.getFirstName())
                    .lastName(data.getLastName())
                    .email(data.getEmail())
                    .build();
            customerRegistrationRequstDTOS.add(customerRegistrationRequstDTO);
        });
       return  customerRegistrationRequstDTOS;
    }
}
