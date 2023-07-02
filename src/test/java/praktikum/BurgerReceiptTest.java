package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    private static final String BUN_NAME = "Булка";
    private static final String INGREDIENT_NAME = "Кетчуп";
    private static final float BUN_PRICE = 100;
    private static final float INGREDIENT_PRICE = 10;
    private static final String RECEIPT =
            "(==== Булка ====)\r\n" +
                    "= sauce Кетчуп =\r\n" +
                    "(==== Булка ====)\r\n" +
                    "\r\n" +
                    "Price: 210,000000\r\n";

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void shouldReturnReceipt() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(bun.getName()).thenReturn(BUN_NAME);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);


        String actual = burger.getReceipt();
        assertEquals(RECEIPT, actual);
    }
}