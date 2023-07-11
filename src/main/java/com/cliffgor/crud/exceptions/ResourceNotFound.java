package com.cliffgor.crud.exceptions;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFound extends RuntimeException{

    private String firstName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFound(String firstName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %sId : %sid",firstName,fieldName,fieldValue));
        this.firstName=firstName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
