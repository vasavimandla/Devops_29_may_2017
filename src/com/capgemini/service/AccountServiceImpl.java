package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
			}

}
