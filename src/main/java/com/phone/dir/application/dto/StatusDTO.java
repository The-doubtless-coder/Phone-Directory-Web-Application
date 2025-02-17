package com.phone.dir.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatusDTO {
    private int statusCode;
    private String statusMessage;
    private String message;
}
