package com.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final  FraudChechHistoryService fraudChechHistoryService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponce isFraudChecking(@PathVariable("customerId") Integer customerId){
        log.info("this customer is checking{}",customerId);
        boolean result = fraudChechHistoryService.isFraudCheck(customerId);
        return  new FraudCheckResponce(result);
    }

}
