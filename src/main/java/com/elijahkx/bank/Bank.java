package com.elijahkx.bank;

import java.util.ArrayList;
import java.util.List;

import com.elijahkx.account.Account;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public double getTotalBalance() {
        double total = 0.0;

        for (Account account : accounts) {
            total += account.getBalance();
        }

        return total;
    }

	public List<Account> getAccounts() {
		return accounts;
	}
}
