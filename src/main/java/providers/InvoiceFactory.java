package providers;

import com.github.javafaker.Faker;
import configuration.FileHandler;
import models.Invoice;

import java.util.Locale;
import java.util.Properties;

public class InvoiceFactory {

    Properties data = FileHandler.getDefaultInvoiceData();

    Faker faker = new Faker(new Locale("pl-PL"));


    public Invoice getRandomInvoiceData() {
        return Invoice.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().streetAddress())
                .postcode(faker.address().zipCode())
                .city(faker.address().city())
                .country(faker.country().name())
                .and()
                .alias("Invoice number: " + faker.number().numberBetween(1, 10) + "/" + faker.number().numberBetween(1, 12))
                .company(faker.company().name())
                .vatNumber(String.valueOf(faker.number().randomNumber()))
                .addressComplement(faker.address().buildingNumber())
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }

    public Invoice getDefaultInvoiceData() {
        return Invoice.builder()
                .firstName(data.getProperty("firstNameInvoice"))
                .lastName(data.getProperty("lastNameInvoice"))
                .address(data.getProperty("addressInvoice"))
                .postcode(data.getProperty("postcodeInvoice"))
                .city(data.getProperty("cityInvoice"))
                .country(data.getProperty("countryInvoice"))
                .and()
                .alias(data.getProperty("aliasInvoice"))
                .company(data.getProperty("companyInvoice"))
                .vatNumber(data.getProperty("vatNumberInvoice"))
                .addressComplement(data.getProperty("addressComplementInvoice"))
                .phone(data.getProperty("phoneInvoice"))
                .build();
    }
}