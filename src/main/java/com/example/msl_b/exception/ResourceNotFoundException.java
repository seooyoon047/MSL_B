package com.example.msl_b.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigInteger;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String dtoName;
    private String fieldName;
    private BigInteger fieldValue;

    public ResourceNotFoundException(String dtoName, String fieldName, BigInteger fieldValue) {
        super(String.format("%s 를 찾지못했습니다 %s : '%s'", dtoName, fieldName, fieldValue));
        this.dtoName = dtoName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
