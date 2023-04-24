package tests.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.cart.ShoppingCartPage;
import pages.menu.TopMenuPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;
import pages.cart.ShoppingCartPopupPage;
import base.TestBase;

public class ProductTest extends TestBase {
    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#productTestDataProvider")
    @DisplayName("Product test")
    @Tag("Product")
    public void shouldVerifyIfProductIsAddedSuccessfully(String productName, int quantity, String expectedConfirmationMessage) {

        at(TopMenuPage.class)
                .goToArt();
        at(ProductGridPage.class)
                .openProduct(productName);
        float currentProductPrice = at(ProductDetailsPage.class).getProductPrice();
        at(ProductDetailsPage.class)
                .setQuantity(quantity)
                .addToCart();
        String actualConfirmationMessage = at(ShoppingCartPopupPage.class)
                .getProductLabelText();
        int expectedProductQuantity = at(ShoppingCartPopupPage.class)
                .getProductQuantity();
        float expectedProductPrice = at(ShoppingCartPopupPage.class)
                .getProductPrice();
        String productCounterMessage = at(ShoppingCartPopupPage.class)
                .getProductsCounterMessage();
        float expectedTotalPrice = at(ShoppingCartPopupPage.class)
                .totalProductValue();
        float totalPrice = at(ShoppingCartPopupPage.class)
                .getTotalPrice();
        at(ShoppingCartPopupPage.class)
                .continueShopping();
        int cartProductNumber = (at(ShoppingCartPage.class)
                .getCartProductsNumber());

        Assertions.assertThat(actualConfirmationMessage).isEqualTo(expectedConfirmationMessage);
        Assertions.assertThat(quantity).isEqualTo(expectedProductQuantity);
        Assertions.assertThat(currentProductPrice).isEqualTo(expectedProductPrice);
        Assertions.assertThat(productCounterMessage).contains(String.valueOf(quantity));
        Assertions.assertThat(totalPrice).isEqualTo(expectedTotalPrice);
        Assertions.assertThat(quantity).isEqualTo(cartProductNumber);
    }
}