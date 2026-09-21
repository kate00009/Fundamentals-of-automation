package ru.netology.service;

import org.testng.annotations.Test;
import org.testng.Assert;

public class CashbackHackServiceTest {

    @Test
    public void shouldCalculateRemainForAmountLessThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int amount = 900;
        int expected = 100;
        int actual = service.remain(amount);

        Assert.assertEquals(actual, expected, "Сумма для докупки рассчитана неверно");
    }

    @Test
    public void shouldCalculateRemainForAmountMoreThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1900; // Ожидаем докупить 100
        int expected = 100;
        int actual = service.remain(amount);

        Assert.assertEquals(actual, expected, "Сумма для докупки рассчитана неверно");
    }

    @Test
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000; // Ровно 1000, докупать ничего не нужно
        int expected = 0;
        int actual = service.remain(amount);

        Assert.assertEquals(actual, expected, "Сервис не должен советовать докупать, если сумма уже кратна 1000");
    }

    @Test
    public void shouldCalculateRemainForLargeAmount() {
        CashbackHackService service = new CashbackHackService();
        int amount = 123_456; // 123456 % 1000 = 456, докупить нужно 544
        int expected = 544;
        int actual = service.remain(amount);

        Assert.assertEquals(actual, expected, "Сумма для докупки рассчитана неверно");
    }

    @Test
    public void shouldCalculateRemainForZeroAmount() {
        CashbackHackService service = new CashbackHackService();
        int amount = 0; // 0 % 1000 = 0, докупить нужно 1000
        int expected = 1000;
        int actual = service.remain(amount);

        Assert.assertEquals(actual, expected, "Для нулевой суммы сервис должен советовать докупить на 1000");
    }
}