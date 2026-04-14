package com.fullstack.service;

import com.fullstack.entity.Customer;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {
        return customerRepository.findByCustEmailIdAndCustPassword(custEmailId, custPassword) != null;
    }

    @Override
    public Optional<Customer> findById(long custId) {
        return Optional.of(customerRepository.findById(custId).orElseThrow(() -> new RecordNotFoundException("Customer #ID Does Not Exist")));

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(long custId, Customer customer) {

        Customer customer1 = findById(custId).get();
        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());


        return customerRepository.save(customer1);
    }

    @Override
    public Customer changeContactNumber(long custId, long custContactNumber) {
        Customer customer = findById(custId).get();

        customer.setCustContactNumber(custContactNumber);

        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(long custId) {
        customerRepository.deleteById(custId);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public List<Customer> saveAll(List<Customer> customerList) {
        return customerRepository.saveAll(customerList);
    }
}
