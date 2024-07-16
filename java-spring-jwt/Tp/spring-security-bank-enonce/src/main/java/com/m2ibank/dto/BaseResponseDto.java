package com.m2ibank.dto;

import lombok.Data;


@Data
public class BaseResponseDto {
    private Object data;
    private Object message;


    public BaseResponseDto(Object message) {
        this.message = message ;
    }

    public BaseResponseDto(Object message, Object data) {
        this.message = message;
        this.data = data;
    }
}
