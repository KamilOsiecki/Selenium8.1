package tests.util_test;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UtilTest {

    public static Stream<Arguments> searchTestDataProvider() {
        return Stream.of(
                Arguments.of("HUMMINGBIRD")
        );
    }

    public static Stream<Arguments> filterTestDataProvider() {
        return Stream.of(
                Arguments.of("13.00", "15.00")
        );
    }

    public static Stream<Arguments> productTestDataProvider() {
        return Stream.of(
                Arguments.of("THE BEST IS YET POSTER", "3", "Product successfully added to your shopping cart"),
                Arguments.of("THE BEST IS YET POSTER", "7", "Product successfully added to your shopping cart"),
                Arguments.of("THE BEST IS YET POSTER", "11", "Product successfully added to your shopping cart"),
                Arguments.of("THE BEST IS YET POSTER", "24", "Product successfully added to your shopping cart")
        );
    }

    public static Stream<Arguments> checkoutTestDataProvider() {
        return Stream.of(
                Arguments.of("osiecki.kamil_tst@gmail.com", "12345", "THE BEST IS YET POSTER",
                        "Please send me a message with the delivery date", "YOUR ORDER IS CONFIRMED")
        );
    }

    public static Stream<Arguments> addProductsTestTestDataProvider() {
        return Stream.of(
                Arguments.of(10)
        );
    }

    public static Stream<Arguments> removeProductsTestDataProvider() {
        return Stream.of(
                Arguments.of(2, "There are no more items in your cart", 0, 1)
        );
    }
}