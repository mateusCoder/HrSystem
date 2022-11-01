package com.mateus.service.impl;

import com.mateus.domain.dto.PayrollDTO;
import com.mateus.domain.dto.PayrollFormDTO;
import com.mateus.domain.dto.UserDTO;
import com.mateus.exception.ObjectNotFoundException;
import com.mateus.feignClients.UserFeign;
import com.mateus.service.PaymentService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final UserFeign userFeign;

    private final Environment env;

    @Override
    public PayrollDTO getPayment(Long workerId, PayrollFormDTO payrollFormDTO) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port ");

        try {
            UserDTO userDTO = userFeign.findById(workerId).getBody();
            if(Objects.nonNull(userDTO)){
                return new PayrollDTO(
                        userDTO.getName(),
                        payrollFormDTO.getDescription(),
                        userDTO.getHourlyPrice(),
                        payrollFormDTO.getWorkedHours(),
                        userDTO.getHourlyPrice() * payrollFormDTO.getWorkedHours());
            }
        } catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException("User not found");
        } catch (Exception ex){
            throw new IllegalArgumentException("illegal argument exception");
        }
        return null;
    }
}
