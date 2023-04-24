package tests.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.search.SearchDropdownPage;
import pages.search.SearchPage;
import base.TestBase;

public class SearchDropdownTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#searchTestDataProvider")
    @DisplayName("Search dropdown test")
    @Tag("Search")
    public void shouldVerifyIfDropdownContainsValue(String expectedValue) {
        at(SearchPage.class)
                .provideProductName(expectedValue);
        Assertions.assertThat(at(SearchDropdownPage.class).getSearchResults()).allMatch(
                actual -> actual.contains(expectedValue));
    }
}