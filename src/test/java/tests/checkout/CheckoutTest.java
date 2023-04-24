package tests.checkout;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import base.TestBase;
import pages.cart.ShoppingCartPage;
import pages.cart.ShoppingCartPopupPage;
import pages.checkout.CheckoutAddressPage;
import pages.checkout.CheckoutPaymentPage;
import pages.checkout.CheckoutShippingPage;
import pages.order.OrderPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;
import pages.search.SearchPage;

public class CheckoutTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#checkoutTestDataProvider")
    @DisplayName("Checkout test")
    @Tag("Checkout")
    public void shouldVerifyCheckoutFunctionality(String email, String password, String productName,
                                                  String deliveryMessage, String expectedOrderConfirmationMessage) {

        userSteps.loginUser(email, password);

        at(SearchPage.class)
                .provideProductName(productName)
                .initSearch();

        at(ProductGridPage.class)
                .openProduct(productName);

        at(ProductDetailsPage.class)
                .addToCart();

        at(ShoppingCartPopupPage.class)
                .proceedToCheckout();

        at(ShoppingCartPage.class)
                .goToCheckout();

        at(CheckoutAddressPage.class)
                .goToInvoiceAddressForm()
                .addInvoiceAddress(invoiceFactory.getRandomInvoiceData());

        at(CheckoutShippingPage.class)
                .setRandomShippingMethod()
                .setDeliveryMessage(deliveryMessage)
                .confirmDeliveryOption();

        at(CheckoutPaymentPage.class)
                .payByCheck()
                .acceptTermsOfService()
                .submitOrder();
        String actualOrderConfirmationMessage = at(OrderPage.class)
                .getOrderConfirmationMessage();

        Assertions.assertThat(actualOrderConfirmationMessage).isEqualTo(expectedOrderConfirmationMessage);
    }
}