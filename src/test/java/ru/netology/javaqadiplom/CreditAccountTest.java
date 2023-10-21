package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldThrowExceptionToNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -100,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowExceptionToNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowExceptionToNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -15
            );
        });
    }

    @Test
    public void shouldPaySuccess() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotPayMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                5000,
                10_000,
                15
        );

        account.pay(20_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldPaySuccessBalanceEqualToCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15
        );

        account.pay(11_000);

        Assertions.assertEquals(-10_000, account.getBalance());
    }

    @Test
    public void shouldPaySuccessCreditLimitBorderMinusOne() {
        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15
        );

        account.pay(10_999);

        Assertions.assertEquals(-9_999, account.getBalance());
    }

    @Test
    public void shouldNotPaySuccessCreditLimitBorderPlusOne() {
        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15
        );

        account.pay(11_001);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldPayNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                15
        );

        account.pay(2_000);
        account.pay(2_000);

        Assertions.assertEquals(-4_000, account.getBalance());
    }

    @Test
    public void shouldNotPayAmountZero() {
        CreditAccount account = new CreditAccount(
                5000,
                10_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        CreditAccount account = new CreditAccount(
                5000,
                10_000,
                15
        );

        account.pay(-1000);

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
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2000);
        account.add(4_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddAmountZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
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
    public void calculatePercentNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void calculatePercentNegativeBalanceUnder100() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(30);

        Assertions.assertEquals(-4, account.yearChange());
    }
    @Test
    public void calculatePercentBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void calculatePercentRateZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}

