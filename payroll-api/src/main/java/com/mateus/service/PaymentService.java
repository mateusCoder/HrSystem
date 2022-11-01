package com.mateus.service;

import com.mateus.domain.dto.PayrollDTO;
import com.mateus.domain.dto.PayrollFormDTO;

public interface PaymentService {
    PayrollDTO getPayment(Long workerId, PayrollFormDTO payrollFormDTO);
}
