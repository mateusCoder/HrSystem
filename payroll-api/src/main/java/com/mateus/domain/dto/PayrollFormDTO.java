package com.mateus.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayrollFormDTO {

    private String workerName;

    private String description;

    private Double hourlyPrice;

    private Double workedHours;

    private Double totalPayment;
}
