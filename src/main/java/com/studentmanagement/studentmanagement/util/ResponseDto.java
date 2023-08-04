package com.studentmanagement.studentmanagement.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private Object data;
    private String message;
    private int code;
}
