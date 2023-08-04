package com.studentmanagement.studentmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProgramDto {
    private Long id;
    private String title;
    private String description;
    private double cost;
}
