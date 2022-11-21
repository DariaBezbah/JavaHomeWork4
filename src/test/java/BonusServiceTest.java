import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateWhenNoRegisteredAndBonusMoreThenLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateWhenRegisteredAndBonusMoreThenLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }
}