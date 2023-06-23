package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private static final String NAME = "Булка";
    private static final float PRICE = 50;
    private static final float DELTA = 0.01f;

    @Test
    public void shouldReturnNameAndPrice() {
        Bun bun = new Bun(NAME, PRICE);

        assertEquals(NAME, bun.getName());
        assertEquals(PRICE, bun.getPrice(), DELTA);
    }
}