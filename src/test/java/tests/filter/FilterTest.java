package tests.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.menu.TopMenuPage;
import pages.filter.FilterPage;
import pages.product.ProductGridPage;
import base.TestBase;

public class FilterTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#filterTestDataProvider")
    @DisplayName("Filter test")
    @Tag("Filter")
    public void shouldFilerProducts(float lowerHandleValue, float higherHandleValue) {
        at(TopMenuPage.class)
                .goToAccessories();
        int initialNumberOfProducts = at(ProductGridPage.class).getProductsListSize();
        at(FilterPage.class)
                .moveLeftSliderTo(lowerHandleValue)
                .moveRightSliderTo(higherHandleValue);
        int filteredNumberOfProducts = at(ProductGridPage.class)
                .getProductsListSize();
        int expectedNumberOfProducts = at(ProductGridPage.class)
                .filterProductsByPrice(lowerHandleValue, higherHandleValue);
        at(FilterPage.class)
                .clearFilter();
        int finalNumberOfProducts = at(ProductGridPage.class)
                .getProducts().size();

        Assertions.assertThat(initialNumberOfProducts).isEqualTo(finalNumberOfProducts);
        Assertions.assertThat(filteredNumberOfProducts).isEqualTo(expectedNumberOfProducts);
    }
}