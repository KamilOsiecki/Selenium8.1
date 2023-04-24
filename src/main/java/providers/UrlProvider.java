package providers;

import configuration.FileHandler;

import java.util.Properties;

public class UrlProvider {
    Properties data = FileHandler.getPageUrlData();
    public static String baseUrl = System.getProperty("app_url");

    public static String basket = baseUrl + "?controller=cart&action=show";
    public static String myAccountPage = baseUrl + System.getProperty("myAccountPage");
    public static String signInPage = baseUrl + System.getProperty("signInPage");
    public static String contactUsPage = baseUrl + System.getProperty("contactUsPage");
}