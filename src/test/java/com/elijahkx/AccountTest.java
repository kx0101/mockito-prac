package com.elijahkx;

import org.junit.jupiter.api.Test;
import com.elijahkx.account.Account;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
