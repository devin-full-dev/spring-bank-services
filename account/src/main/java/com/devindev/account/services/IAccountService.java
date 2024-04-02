package com.devindev.account.services;

import com.devindev.account.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
}
