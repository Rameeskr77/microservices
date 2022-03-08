package com.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudChechHistoryService {

    private final  FraudCheckRepository fraudCheckRepository;

    public boolean isFraudCheck(Integer companyId){
        fraudCheckRepository.save(
                FraudCheckHistory.builder()
                        .customerId(companyId)
                        .isfraud(false)
                        .craeDateTime(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
