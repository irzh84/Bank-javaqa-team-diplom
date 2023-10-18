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
// баг начальный баланс не может быть отрицательным

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
// баг кредитный лимит не может быть отрицательным

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
// баг ставка кредитования не может быть отрицательной

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

    // баг на баланс равен отрицательтельной сумме покупки
    // баланс = баланс - сумма покупки

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

    // баг на баланс меняется при превышении кредитного лимита
    // баланс должен не меняться, баланс = баланс

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

    // баг на начальный баланс не увеличивается на сумму пополнения
    // баланс = баланс + сумма пополнения

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

    // баг при балансе до 100, отбрасывается дробная часть и далее идет умножение нуля на ставку
    // решение  double yearChangeDoble = (double) balance / 100 * rate;
    //          return (int) yearChangeDoble;

    @Test
    public void calculatePercentPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

// баг на при положительном балансе сумма процентов не равна 0

}
