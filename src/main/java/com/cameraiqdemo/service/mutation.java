package com.cameraiqdemo.service;

import com.cameraiqdemo.model.CreateOrganization;
import com.cameraiqdemo.model.CreateUser;
import com.cameraiqdemo.model.Organization;
import com.cameraiqdemo.model.User;
import com.cameraiqdemo.repository.OrganizationRepository;
import com.cameraiqdemo.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class mutation implements GraphQLMutationResolver {

    private OrganizationRepository organizationRepository;
    private UserRepository userRepository;

    @Transactional
    public Organization newOrganization(CreateOrganization input){
        return organizationRepository.save(new Organization(input.getId(), input.getName(), input.getAddress(), input.getPhone()));
    }

    @Transactional
    public User newUser(CreateUser input){
        return userRepository.save(new User(input.getId(), input.getFirstname(), input.getLastname(), input.getEmail(), input.getAddress(), input.getPhone()));
    }

    @Transactional
    public Organization addUserToOrganization(int org_id, int user_id){
        Organization o1 = organizationRepository.findById(org_id).orElseThrow(() -> new IllegalArgumentException("Organization not found!"));
        o1.getUsers().add(userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("User not found!")));
        return organizationRepository.save(o1);
    }

    @Transactional
    public Organization deleteUserFromOrganization(int org_id, int user_id){
        Organization o1 = organizationRepository.findById(org_id).orElseThrow(() -> new IllegalArgumentException("Organization not found!"));
        o1.getUsers().remove(userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("User not found!")));
        return organizationRepository.save(o1);
    }

}
