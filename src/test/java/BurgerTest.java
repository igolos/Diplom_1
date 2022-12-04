
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Test
    public void getPriceCorrect() {

        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("Test", 2f));
        burger.ingredients.add(new Ingredient(SAUCE, "Test", 2f));
        burger.setBuns(buns.get(0));
        float actualPrice= burger.getPrice();
        assertEquals("Another price", 6, actualPrice, 0.0f);


    }
    @Test
    public void getReceiptCorrect() {

        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("Test", 2f));
        burger.ingredients.add(new Ingredient(SAUCE, "Test", 2f));
        burger.setBuns(buns.get(0));
        String actualPrice= burger.getReceipt();
        String upBun ="(==== Test ====)";
        String inBurger="= sauce Test =";
        String downBun="(==== Test ====)";
        String priceBurger="Price: 6,000000";
        MatcherAssert.assertThat(actualPrice, allOf(startsWith(upBun), containsString(inBurger), containsString(downBun),containsString(priceBurger)));
    }

    @Mock
    Bun bun;

    @Test
    public void setBunsCorrect() {
        List<Bun> buns = new ArrayList<>();
        Burger burger = new Burger();
        burger.setBuns(bun);
        buns.add(bun);
        assertEquals(false, buns.isEmpty());

    }


    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientCorrect() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(false, burger.ingredients.isEmpty());

    }

    @Test
    public void removeIngredientCorrect() {

        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals(true, burger.ingredients.isEmpty());
    }

    @Mock
    Ingredient ingredientTwo;

    @Test
    public void moveIngredientCorrect() {

        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientTwo);
        burger.moveIngredient(0, 1);
        int actualIndex = burger.ingredients.indexOf(ingredient);
        assertEquals(1, actualIndex);
    }

}