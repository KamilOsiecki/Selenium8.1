package models;

import lombok.Getter;

@Getter
public class Invoice {
    private String alias;
    private String firstName;
    private String lastName;
    private String company;
    private String vatNumber;
    private String address;
    private String addressComplement;
    private String postcode;
    private String city;
    private String country;
    private String phone;

    public static Invoice.NeedFirstName builder() {
        return new Builder();
    }

    public static class Builder implements Invoice.NeedFirstName, Invoice.NeedLastName, Invoice.NeedAddress,
            Invoice.NeedPostcode, Invoice.NeedCity, Invoice.NeedCountry, Invoice.CanBeBuild {
        private String alias;
        private String firstName;
        private String lastName;
        private String company;
        private String vatNumber;
        private String address;
        private String addressComplement;
        private String postcode;
        private String city;
        private String country;
        private String phone;

        @Override
        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        @Override
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public Builder company(String company) {
            this.company = company;
            return this;
        }

        @Override
        public Builder vatNumber(String vatNumber) {
            this.vatNumber = vatNumber;
            return this;
        }

        @Override
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        @Override
        public Builder addressComplement(String addressComplement) {
            this.addressComplement = addressComplement;
            return this;
        }

        @Override
        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        @Override
        public Builder city(String city) {
            this.city = city;
            return this;
        }

        @Override
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        @Override
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        @Override
        public Builder and() {
            return this;
        }

        public Invoice build() {
            Invoice invoice = new Invoice();
            invoice.alias = this.alias;
            invoice.firstName = this.firstName;
            invoice.lastName = this.lastName;
            invoice.company = this.company;
            invoice.vatNumber = this.vatNumber;
            invoice.address = this.address;
            invoice.addressComplement = this.addressComplement;
            invoice.postcode = this.postcode;
            invoice.city = this.city;
            invoice.country = this.country;
            invoice.phone = this.phone;
            return invoice;
        }
    }

    public interface NeedFirstName {
        Invoice.NeedLastName firstName(String firstName);
    }

    public interface NeedLastName {
        Invoice.NeedAddress lastName(String lastName);
    }

    public interface NeedAddress {
        NeedPostcode address(String address);
    }

    public interface NeedPostcode {
        Invoice.NeedCity postcode(String postcode);
    }

    public interface NeedCity {
        Invoice.NeedCountry city(String city);
    }

    public interface NeedCountry {
        Invoice.NeedCountry country(String country);

        Invoice.CanBeBuild and();
    }

    public interface CanBeBuild {
        CanBeBuild alias(String alias);

        CanBeBuild company(String company);

        CanBeBuild vatNumber(String vatNumber);

        CanBeBuild addressComplement(String addressComplement);

        CanBeBuild phone(String phone);

        Invoice build();
    }
}