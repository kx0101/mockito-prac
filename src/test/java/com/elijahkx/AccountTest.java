package com.elijahkx.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void testDeposit() {
        Account account = new Account("1234567890", 100.0);

        account.deposit(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdrawSufficientBalance() {
        Account account = new Account("1234567890", 100.0);

        account.withdraw(50.0);

        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Account account = new Account("1234567890", 100.0);

        account.withdraw(150.0);

        assertEquals(100.0, account.getBalance());
    }
}
