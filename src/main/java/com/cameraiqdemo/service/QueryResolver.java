package com.cameraiqdemo.service;

import com.cameraiqdemo.model.Organization;
import com.cameraiqdemo.model.User;
import com.cameraiqdemo.repository.OrganizationRepository;
import com.cameraiqdemo.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private OrganizationRepository organizationRepository;
    private UserRepository userRepository;

    @Transactional
    public Set<User> getAllUsersByOrgId(int org_id){
        Organization o1 = organizationRepository.findById(org_id).orElseThrow(() -> new IllegalArgumentException("Organization not found!"));
        Hibernate.initialize(o1.getUsers());
        return o1.getUsers();
    }

    @Transactional
    public Set<Organization> getAllOrganizationByUserId(int user_id){
        User u1 = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("User not found!"));
        Hibernate.initialize(u1.getOrganizations());
        return u1.getOrganizations();
    }

}

