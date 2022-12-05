import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
@Mock
    IngredientType SAUCE;
    @Test
    public void getTypeCorrect() {

        Ingredient ingredient = new Ingredient(SAUCE, "Барбекю", 1.2f);
        IngredientType expectedType = SAUCE;

        IngredientType actualType = ingredient.getType();

        Assert.assertEquals("Another type", expectedType, actualType);
    }
    @Test
    public void getPriceCorrect() {

        Ingredient ingredient = new Ingredient(SAUCE, "Барбекю", 1.2f);
        float expectedPrice = 1.2f;

        float actualPrice = ingredient.getPrice();


        Assert.assertEquals(expectedPrice, actualPrice,0.0f);
    }
    @Test
    public void getNameCorrect() {

        Ingredient ingredient = new Ingredient(SAUCE, "Барбекю", 1.2f);
        String expectedName = "Барбекю";

        String actualName = ingredient.getName();

        Assert.assertEquals("Another name", expectedName, actualName);
    }

}
