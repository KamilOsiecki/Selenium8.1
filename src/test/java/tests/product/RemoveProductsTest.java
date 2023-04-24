package tests.product;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.cart.ShoppingCartPage;

public class RemoveProductsTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#removeProductsTestDataProvider")
    @DisplayName("Remove products")
    @Tag("Product")
    public void shouldRemoveProductsFromBasket(int numberOfProductsToAdd, String expectedBasketMessage,
                                               int productToDelete1, int productToDelete2){

        userSteps.addProductToBasket(numberOfProductsToAdd);
        userSteps.goToBasket();
        float actualTotalPrice = at(ShoppingCartPage.class).getCartsProductsTotalPrice();
        float expectedTotalPrice = at(ShoppingCartPage.class).getCartsProductsTotalPrice();

        at(ShoppingCartPage.class).removeProductFromCart(productToDelete1);

        float newActualTotalPrice = at(ShoppingCartPage.class).getCartsProductsTotalPrice();
        float newExpectedTotalPrice = at(ShoppingCartPage.class).getCartsProductsTotalPrice();

        at(ShoppingCartPage.class).removeProductFromCart(productToDelete2);

        String actualBasketMessage = at(ShoppingCartPage.class).getNoItemsMessage();

        Assertions.assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
        Assertions.assertThat(newActualTotalPrice).isEqualTo(newExpectedTotalPrice);
        Assertions.assertThat(actualBasketMessage).isEqualTo(expectedBasketMessage);
    }
}