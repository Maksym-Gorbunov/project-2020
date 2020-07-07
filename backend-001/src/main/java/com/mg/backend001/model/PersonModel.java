package com.mg.backend001.model;

import lombok.*;

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
