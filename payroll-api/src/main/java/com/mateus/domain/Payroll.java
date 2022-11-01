package com.mateus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payroll {

    private String workerName;

    private String description;

    private Double hourlyPrice;

    private Double workedHours;

    private Double totalPayment;
}
