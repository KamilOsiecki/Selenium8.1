package tests.product;

import base.TestBase;
import models.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.cart.ShoppingCartPage;

public class AddProductsTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#addProductsTestTestDataProvider")
    @DisplayName("Add products test")
    @Tag("Product")
    public void shouldAddProductsAndCheckOrderDetails(int numberOfProductsToAdd){
        Order expectedOrder = userSteps.addProductToBasket(numberOfProductsToAdd);
        userSteps.goToBasket();
        Order actualOrder = at(ShoppingCartPage.class).getOrder();
        Assertions.assertThat(actualOrder).usingRecursiveComparison().isEqualTo(expectedOrder);
    }
}