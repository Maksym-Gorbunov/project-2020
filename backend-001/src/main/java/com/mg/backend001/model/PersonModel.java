package com.mg.backend001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    private String personal_number;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

}
