package com.mateus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormDTO {

    private String name;

    private String email;

    private String password;

    private Double hourlyPrice;
}
