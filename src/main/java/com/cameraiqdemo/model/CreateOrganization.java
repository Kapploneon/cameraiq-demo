package com.cameraiqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrganization {

    private int id;
    private String name;
    private String address;
    private String phone;

    public int getId() {return this.id;}

    public String getName() {return this.name;}
    public String getAddress() {return this.address;}
    public String getPhone() {return this.phone;}

}
