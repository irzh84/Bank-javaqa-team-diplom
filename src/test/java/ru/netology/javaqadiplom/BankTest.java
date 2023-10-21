package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void transferSuccessWithSufficientBalanceAndBelowLimit() {
        SavingAccount account1 = new SavingAccount(
                5_000,
                0,
                10_000,
                0
        );
        SavingAccount account2 = new SavingAccount(
                0,
                0,
                10_000,
                0
        );

        Bank bank = new Bank();
        bank.transfer(account1, account2, 1_000);

        Assertions.assertEquals(4_000, account1.getBalance());
        Assertions.assertEquals(1_000, account2.getBalance());
    }

    @Test
    public void transferNotSuccessWithInsufficientBalance() {
        SavingAccount account1 = new SavingAccount(
                5_000,
                0,
                10_000,
                0
        );
        SavingAccount account2 = new SavingAccount(
                0,
                0,
                10_000,
                0
        );

        Bank bank = new Bank();
        bank.transfer(account1, account2, 6_000);

        Assertions.assertEquals(5_000, account1.getBalance());
        Assertions.assertEquals(0, account2.getBalance());


    }

    @Test
    public void transferNotSuccessAboveLimit() {
        SavingAccount account1 = new SavingAccount(
                5_000,
                0,
                10_000,
                0
        );
        SavingAccount account2 = new SavingAccount(
                10_000,
                0,
                10_000,
                0
        );

        Bank bank = new Bank();
        bank.transfer(account1, account2, 5_000);

        Assertions.assertEquals(5_000, account1.getBalance());
        Assertions.assertEquals(10_000, account2.getBalance());
    }
}
