package com.cameraiqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String firstname;

    @NotNull
    @Size(max = 100)
    private String lastname;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "users")
    private Set<Organization> organizations = new HashSet<>();


    private String email;

    @NotNull
    @Size(max = 250)
    private String address;

    private String phone;

    public User(int id, String firstname, String lastname, String email, String address, String phone){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Set<Organization> getOrganizations() {return organizations;}
    public void setOrganizations(Set<Organization> organizations) {this.organizations = organizations;}

}