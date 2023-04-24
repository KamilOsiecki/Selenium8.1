package tests.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.product.ProductGridPage;
import pages.search.SearchPage;
import base.TestBase;

public class SearchTest extends TestBase {

    @Test
    @DisplayName("Search test")
    @Tag("Search")
    public void shouldVerifyNameOfSearchedProduct() {

        var expectedValue = at(ProductGridPage.class)
                .getRandomProductName();

        at(SearchPage.class)
                .provideProductName(expectedValue)
                .initSearch();

        var searchResults = at(ProductGridPage.class)
                .getProducts();

        Assertions.assertThat(searchResults.size()).isEqualTo(1);
        Assertions.assertThat(searchResults.get(0).getTitle()).isEqualTo(expectedValue);
    }
}