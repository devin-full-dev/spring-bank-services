package com.devindev.account.mapper;

import com.devindev.account.dto.CustomerDto;
import com.devindev.account.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapEntityToDto(Customer customer, CustomerDto customerDto){
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapDtoToEntity(CustomerDto customerDto, Customer customer){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
