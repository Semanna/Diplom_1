package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void shouldContainsSouse() {
        IngredientType type = IngredientType.valueOf("SAUCE");

        assertEquals(type, IngredientType.SAUCE);
    }

    @Test
    public void shouldContainsFilling() {
        IngredientType type = IngredientType.valueOf("FILLING");

        assertEquals(type, IngredientType.FILLING);
    }
}