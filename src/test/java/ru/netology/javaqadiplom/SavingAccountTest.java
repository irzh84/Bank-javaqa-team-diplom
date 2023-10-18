package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void initialBalanceCanNotBeNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -1,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialMinBalanceCanNotBeNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialMaxBalanceCanNotBeNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    -1,
                    5
            );
        });
    }

    @Test
    public void initialRateCanNotBeNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    public void minBalanceCanNotMoreMaxBalanceTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    11_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialBalanceCanNotMoreMaxBalanceTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    11_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void initialBalanceCanNotLessMinBalanceTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldAddMinBalanceTest() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMinBalanceTest() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        account.add(11_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddBelowMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddBelowMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.add(7_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                10_000,
                0,
                10_000,
                5
        );

        account.add(5_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }


    @Test
    public void shouldNotAddToNegativeTest() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.add(-5);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldAddToZeroTest() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldNotPayMinBalanceTest() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayBelowMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldPayAtMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                10_000,
                0,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(9_500, account.getBalance());
    }

    @Test
    public void amountCanNotMoreCurrentBalanceTest() {
        SavingAccount account = new SavingAccount(
                5_000,
                0,
                10_000,
                5
        );

        account.pay(6_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }


    @Test
    public void successfulYearChangeTest() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void successfulYearChangeAtMinBalanceTest() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());

    }

    @Test
    public void successfulYearChangeZeroPercentTest() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());

    }

    @Test
    public void successfulYearChangeAtMaxBalanceTest() {
        SavingAccount account = new SavingAccount(
                10_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(500, account.yearChange());

    }

    @Test
    public void successfulYearChangeZeroPercentAtMinBalanceTest() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());

    }
}
