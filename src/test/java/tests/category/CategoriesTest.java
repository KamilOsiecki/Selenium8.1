package tests.category;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.category.CategoryPage;
import pages.menu.TopMenuPage;
import pages.filter.FilterPage;
import pages.product.ProductGridPage;
import base.TestBase;

public class CategoriesTest extends TestBase {

    @Test
    @DisplayName("Categories test")
    @Tag("Category")
    public void shouldVerifyElementsOnCategory() {
        for (int i = 0; i < at(TopMenuPage.class).getCategoriesSize(); i++) {
            String actualCategoryName = at(TopMenuPage.class)
                    .getCategoryName(i);

            at(TopMenuPage.class)
                    .goToCategory(i);

            String expectedCategoryName = at(CategoryPage.class)
                    .getCategoryNameHeader();

            at(FilterPage.class)
                    .isSearchFilterDisplayed();

            int numberOfProductsOnPage = at(ProductGridPage.class)
                    .getProductsListSize();

            String numberOfProductsText = at(CategoryPage.class)
                    .numberOfProductsText();

            Assertions.assertThat(actualCategoryName).isEqualTo(expectedCategoryName);
            Assertions.assertThat(numberOfProductsText).contains(String.valueOf(numberOfProductsOnPage));
        }
    }

    @Test
    @DisplayName("Sub-categories test")
    @Tag("Category")
    public void shouldVerifyElementsOnSubCategories() {

        for (int i = 0; i < at(TopMenuPage.class).getCategoriesSize(); i++) {
            at(TopMenuPage.class)
                    .goToCategory(i);

            if (at(CategoryPage.class).isSubCategoryExist()) {
                int numberOfSubCategories = at(CategoryPage.class).getSubCategoriesSize();

                for (int j = 0; j < numberOfSubCategories; j++) {

                    String actualSubCategoryName = at(CategoryPage.class)
                            .getSubCategoryName(j);

                    at(CategoryPage.class)
                            .goToSubCategory(j);

                    at(FilterPage.class)
                            .isSearchFilterDisplayed();

                    String expectedSubCategoryName = at(CategoryPage.class)
                            .getCategoryNameHeader();

                    int numberOfProductsOnPage = at(ProductGridPage.class)
                            .getProductsListSize();

                    String numberOfProductsText = at(CategoryPage.class)
                            .numberOfProductsText();

                    Assertions.assertThat(actualSubCategoryName).isEqualTo(expectedSubCategoryName);
                    Assertions.assertThat(numberOfProductsText).contains(String.valueOf(numberOfProductsOnPage));

                    at(TopMenuPage.class)
                            .goToCategory(i);
                }
            }
        }
    }
}