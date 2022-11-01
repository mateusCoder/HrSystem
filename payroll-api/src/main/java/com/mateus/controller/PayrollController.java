package com.mateus.controller;

import com.mateus.domain.dto.PayrollDTO;
import com.mateus.domain.dto.PayrollFormDTO;
import com.mateus.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payments")
@RestController
@RequiredArgsConstructor
public class PayrollController {

    private final PaymentServiceImpl paymentService;

    @GetMapping("/{workerId}")
    public ResponseEntity<PayrollDTO> getPayment(@PathVariable Long workerId, @RequestBody PayrollFormDTO payrollFormDTO){
        return ResponseEntity.ok(paymentService.getPayment(workerId, payrollFormDTO));
    }
}
