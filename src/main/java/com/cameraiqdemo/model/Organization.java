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
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 250)
    private String address;

    private String phone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "org_user",
            joinColumns = { @JoinColumn(name = "org_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<>();

    public Organization(int id, String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}

}