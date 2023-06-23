package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private static final float DELTA = 0.01f;
    private final float bunPrice;
    private final float ingredientPrice;
    private final float totalPrice;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    public BurgerPriceTest(float bunPrice, float ingredientPrice, float totalPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.totalPrice = totalPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {100f, 10f, 210f},
                {150f, 5f, 305f}
        });
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnPrice() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float actual = burger.getPrice();
        assertEquals(totalPrice, actual, DELTA);
    }
}