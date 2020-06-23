package com.mg.backend001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    private String personalNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
