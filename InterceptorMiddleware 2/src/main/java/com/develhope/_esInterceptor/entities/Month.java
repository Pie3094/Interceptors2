package com.develhope._esInterceptor.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Month {


    private int month_number;
    private String english_name;
    private String italian_name;
    private String german_name;
}
