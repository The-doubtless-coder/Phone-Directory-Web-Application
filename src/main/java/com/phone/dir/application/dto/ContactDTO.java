package com.phone.dir.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactDTO {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String idNumber;
    private String dob;
    private String gender;
    private String organization;
}
