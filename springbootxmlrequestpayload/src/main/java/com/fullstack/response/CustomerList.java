package com.fullstack.response;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fullstack.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "Customers")
public class CustomerList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Customer")
    private List<Customer> customers;
}