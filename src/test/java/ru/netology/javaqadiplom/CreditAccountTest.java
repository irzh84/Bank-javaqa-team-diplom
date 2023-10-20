package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldThrowExceptionToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -100,
                5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getBalance();
        });
    }

    @Test
    public void shouldThrowExceptionToNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                -5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getCreditLimit();
        });
    }

    @Test
    public void shouldThrowExceptionToNegativeRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                -15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
        });
    }

    @Test
    public void shouldPaySucsess() {
        CreditAccount account = new CreditAccount(
                5000,
                10_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldPayAmountMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                5000,
                10_000,
                15
        );

        account.pay(20_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void calculatePercentNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void calculatePercentNegativeBalanceUnder100() {
        CreditAccount account = new CreditAccount(
                -30,
                5_000,
                15
        );

        Assertions.assertEquals(-4, account.yearChange());
    }

    @Test
    public void calculatePercentPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void calculateZeroPercentPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    
}
