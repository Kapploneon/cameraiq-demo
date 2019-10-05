package com.cameraiqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phone;

    public int getId() {return this.id;}

    public String getFirstname() {return this.firstname;}
    public String getLastname() {return this.lastname;}
    public String getEmail() {return this.email;}
    public String getAddress() {return this.address;}
    public String getPhone() {return this.phone;}

}
