package providers;

import com.github.javafaker.Faker;
import configuration.FileHandler;
import models.User;

import java.util.Locale;
import java.util.Properties;

public class UserFactory {

    Properties data = FileHandler.getAlreadyRegisteredUserData();
    Faker faker = new Faker(new Locale("pl-PL"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    public User getRandomUser() {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(faker.internet().emailAddress(firstName + "." + lastName).toLowerCase())
                .password(faker.internet().password(10, 15, true, true, true))
                .customerPrivacy(true)
                .generalTerms(true)
                .and()
                .build();
    }

    public User getAlreadyRegisteredUser() {
        return User.builder()
                .firstName(data.getProperty("userFirstName"))
                .lastName(data.getProperty("userLastName"))
                .email(data.getProperty("userEmail"))
                .password(data.getProperty("userPassword"))
                .customerPrivacy(Boolean.parseBoolean(data.getProperty("userCustomerPrivacy")))
                .generalTerms(Boolean.parseBoolean(data.getProperty("userGeneralTerms")))
                .and().build();
    }
}