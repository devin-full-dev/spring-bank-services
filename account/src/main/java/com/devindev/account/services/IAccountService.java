package com.devindev.account.services;

import com.devindev.account.dto.CustomerDto;
import com.devindev.account.entity.Customer;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    Customer getAccountDetails(String mobileNumberad
}
