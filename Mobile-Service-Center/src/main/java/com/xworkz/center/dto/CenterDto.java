package com.xworkz.center.dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class CenterDto {
    private Integer ID;
    private String centerName;
    private String mobileBrand;
    private Integer  modelNumber;
    private String defectType;
    private String custumberName;
    private String warrentry;
}
