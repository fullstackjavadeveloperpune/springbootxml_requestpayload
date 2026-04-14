package com.fullstack.controller;

import com.fullstack.dto.LogInRequest;
import com.fullstack.entity.Customer;
import com.fullstack.response.CustomerList;
import com.fullstack.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping(
            value = "/saveall",
            consumes = "application/xml",
            produces = "application/xml"
    )
    public ResponseEntity<List<Customer>> saveAll(@RequestBody CustomerList customerList) {

        if (customerList == null || customerList.getCustomers() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return new ResponseEntity<>(
                customerService.saveAll(customerList.getCustomers()),
                HttpStatus.CREATED
        );
    }

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Customer> signUp(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(customerService.signUp(customer), HttpStatus.CREATED);
    }

    @PostMapping(value = "/signin", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Boolean> signIn(@RequestBody LogInRequest logInRequest) {

        return new ResponseEntity<>(customerService.signIn(logInRequest.custEmailId(), logInRequest.custPassword()), HttpStatus.OK);

    }

    @GetMapping(value = "/findbyid/{custId}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Optional<Customer>> findById(@PathVariable long custId) {
        return new ResponseEntity<>(customerService.findById(custId), HttpStatus.OK);
    }

    @GetMapping(value = "/findall", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{custId}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Customer> update(@PathVariable long custId, @Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(custId, customer), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/changecontactnumber/{custId}/{custContactNumber}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Customer> changeContactNumber(@PathVariable long custId, @PathVariable long custContactNumber) {
        return new ResponseEntity<>(customerService.changeContactNumber(custId, custContactNumber), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<Void> deleteById(@PathVariable long custId) {
        customerService.deleteById(custId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAll() {
        customerService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
