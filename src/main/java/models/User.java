package models;

import lombok.Getter;

@Getter
public class User {
    private String socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;
    private Boolean partnersOffers;
    private Boolean customerPrivacy;
    private Boolean newsletter;
    private Boolean generalTerms;

    public static NeedFirstName builder() {
        return new Builder();
    }

    public static class Builder implements NeedFirstName, NeedLastName, NeedEmail, NeedPassword,
            NeedCustomerPrivacy, NeedGeneralTerms, CanBeBuild {

        private String socialTitle;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthdate;
        private Boolean partnersOffers;
        private Boolean customerPrivacy;
        private Boolean newsletter;
        private Boolean generalTerms;

        @Override
        public Builder socialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
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
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public Builder birthdate(String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        @Override
        public Builder partnersOffers(Boolean partnersOffers) {
            this.partnersOffers = partnersOffers;
            return this;
        }

        @Override
        public Builder customerPrivacy(Boolean customerPrivacy) {
            this.customerPrivacy = customerPrivacy;
            return this;
        }

        @Override
        public Builder newsletter(Boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        @Override
        public Builder generalTerms(Boolean generalTerms) {
            this.generalTerms = generalTerms;
            return this;
        }

        @Override
        public Builder and() {
            return this;
        }

        public User build() {
            User user = new User();
            user.socialTitle = this.socialTitle;
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            user.password = this.password;
            user.birthdate = this.birthdate;
            user.partnersOffers = this.partnersOffers;
            user.customerPrivacy = this.customerPrivacy;
            user.newsletter = this.newsletter;
            user.generalTerms = this.generalTerms;
            return user;
        }
    }

    public interface NeedFirstName {
        User.NeedLastName firstName(String firstName);
    }

    public interface NeedLastName {
        User.NeedEmail lastName(String lastName);
    }

    public interface NeedEmail {
        User.NeedPassword email(String email);
    }

    public interface NeedPassword {
        User.NeedCustomerPrivacy password(String password);
    }

    public interface NeedCustomerPrivacy {
        User.NeedGeneralTerms customerPrivacy(Boolean customerPrivacy);
    }

    public interface NeedGeneralTerms {
        NeedGeneralTerms generalTerms(Boolean generalTerms);

        User.CanBeBuild and();
    }

    public interface CanBeBuild {
        CanBeBuild socialTitle(String socialTitle);

        CanBeBuild birthdate(String birthdate);

        CanBeBuild partnersOffers(Boolean partnersOffers);

        CanBeBuild newsletter(Boolean newsletter);

        User build();
    }

    @Override
    public String toString() {
        return "FirstName| " + firstName
                + "\nLastName|  " + lastName
                + "\nEmail| " + email
                + "\nPassword| " + password;
    }
}