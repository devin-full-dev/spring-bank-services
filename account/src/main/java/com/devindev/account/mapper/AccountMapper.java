package com.devindev.account.mapper;

import com.devindev.account.dto.AccountDto;
import com.devindev.account.entity.Account;

public class AccountMapper {
    public static AccountDto mapEntityToDto(Account account, AccountDto accountDto){
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account mapDtoToEntity(AccountDto accountDto, Account account){
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
