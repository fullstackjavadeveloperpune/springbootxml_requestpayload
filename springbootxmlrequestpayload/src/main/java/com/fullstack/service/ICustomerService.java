package com.fullstack.service;

import com.fullstack.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer signUp(Customer customer);

    boolean signIn(String custEmailId, String custPassword);

    Optional<Customer> findById(long custId);

    List<Customer> findAll();

    Customer update(long custId, Customer customer);

    Customer changeContactNumber(long custId, long custContactNumber);

    void deleteById(long custId);

    void deleteAll();

    List<Customer> saveAll(List<Customer> customerList);
}
