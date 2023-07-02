package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    private static final Database database = new Database();
    private static final float DELTA = 0.01f;
    private static final List<Bun> BUNS = List.of(
            new Bun("black bun", 100),
            new Bun("white bun", 200),
            new Bun("red bun", 300)
    );

    private static final List<Ingredient> INGREDIENTS = List.of(
            new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
            new Ingredient(IngredientType.SAUCE, "sour cream", 200),
            new Ingredient(IngredientType.SAUCE, "chili sauce", 300),

            new Ingredient(IngredientType.FILLING, "cutlet", 100),
            new Ingredient(IngredientType.FILLING, "dinosaur", 200),
            new Ingredient(IngredientType.FILLING, "sausage", 300)
    );

    @Test
    public void shouldReturnAvailableBuns() {
        List<Bun> actual = database.availableBuns();

        Assert.assertEquals(BUNS.size(), actual.size());
        for (int i = 0; i < BUNS.size(); i++) {
            assertEquals(BUNS.get(i), actual.get(i));
        }
    }

    @Test
    public void shouldReturnAvailableIngredients() {
        List<Ingredient> actual = database.availableIngredients();

        Assert.assertEquals(INGREDIENTS.size(), actual.size());
        for (int i = 0; i < INGREDIENTS.size(); i++) {
            assertEquals(INGREDIENTS.get(i), actual.get(i));
        }
    }

    private void assertEquals(Bun bun1, Bun bun2) {
        Assert.assertEquals(bun1.getName(), bun2.getName());
        Assert.assertEquals(bun1.getPrice(), bun2.getPrice(), DELTA);
    }

    private void assertEquals(Ingredient ingredient1, Ingredient ingredient2) {
        Assert.assertEquals(ingredient1.getName(), ingredient2.getName());
        Assert.assertEquals(ingredient1.getType(), ingredient2.getType());
        Assert.assertEquals(ingredient1.getPrice(), ingredient1.getPrice(), DELTA);
    }
}