package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private static final String NAME = "Булка";
    private static final float PRICE = 50;
    private static final float DELTA = 0.01f;

    @Test
    public void shouldReturnNamePriceAndType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, NAME, PRICE);

        assertEquals(NAME, ingredient.getName());
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals(PRICE, ingredient.getPrice(), DELTA);
    }
}