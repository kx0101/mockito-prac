package com.elijahkx;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.elijahkx.account.Account;
import com.elijahkx.bank.Bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankTest {

    @Mock
    private Account account1;

    @Mock
    private Account account2;

    @InjectMocks
    private Bank bank;

    @Test
    public void testAddAccount() {
        Account account = new Account("1234567890", 100.0);

        bank.addAccount(account);

        assertEquals(1, bank.getAccounts().size());
        assertEquals(account, bank.getAccounts().get(0));

        Account account2 = new Account("123456", 150.0);

        bank.addAccount(account2);

        assertEquals(250.0, bank.getTotalBalance(), 0.01);
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    public void testRemoveAccount() {
        Account account = new Account("1234567890", 100.0);

        bank.addAccount(account);

        bank.removeAccount(account);

        assertEquals(0, bank.getAccounts().size());
        assertEquals(0, bank.getTotalBalance(), 0.01);
    }

    @Test
    public void testGetTotalBalance() {
        when(account1.getBalance()).thenReturn(100.0);
        when(account2.getBalance()).thenReturn(200.0);

        bank.addAccount(account1);
        bank.addAccount(account2);

        assertEquals(300.0, bank.getTotalBalance());
    }
}
