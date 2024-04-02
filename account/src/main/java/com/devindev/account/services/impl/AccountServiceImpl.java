package com.devindev.account.services.impl;

import com.devindev.account.constants.AccountConstants;
import com.devindev.account.dto.CustomerDto;
import com.devindev.account.entity.Account;
import com.devindev.account.entity.Customer;
import com.devindev.account.exception.CustomerExistException;
import com.devindev.account.mapper.CustomerMapper;
import com.devindev.account.repository.AccountRepository;
import com.devindev.account.repository.CustomerRepository;
import com.devindev.account.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapDtoToEntity(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerExistException("Customer Already Exist with given Mobile Number"+ customerDto.getMobileNumber()+"!");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer saveCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(saveCustomer));
    }

    private Account createNewAccount (Customer customer) {
        Random random = new Random();
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber= 1000000000L + random.nextInt (900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
