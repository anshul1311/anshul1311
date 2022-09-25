package stepdefination;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.apimanager.CreateUserApiManager;
import utils.datareader.ReadConfig;
import utils.logger.Log;
import utils.yamlreader.YamlReader;
import webpageobjects.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

@Test(retryAnalyzer = utils.listeners.RetryListener.class)
public class PlaceOrder {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    CreateUserApiManager createUserApiManager;
    HomePage homePage;
    ProductListingPage productListingPage;
    ProductDetailsPage productDetailsPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;
    SuccessPage successPage;
    CommonElements commonElements;
    String url;
    String path = "config.properties";

    @Before(value = "@happily",order = 1)
    public void setup() throws IOException {
        Log.info("Inside Setup");
        loginPage = new LoginPage(ReadConfig.getInstance(path).getProperty("web.url"));
        registrationPage = new RegistrationPage(loginPage.getDriver());
        homePage = new HomePage(loginPage.getDriver());
        productListingPage = new ProductListingPage(loginPage.getDriver());
        productDetailsPage = new ProductDetailsPage(loginPage.getDriver());
        checkOutPage = new CheckOutPage(loginPage.getDriver());
        paymentPage = new PaymentPage(loginPage.getDriver());
        successPage = new SuccessPage(loginPage.getDriver());
        commonElements = new CommonElements(loginPage.getDriver());
    }



    @Before("  @Negative")
    public void setupForRandomApi1() throws IOException {
        loginPage = new LoginPage(ReadConfig.getInstance(path).getProperty("web.url"));
        registrationPage = new RegistrationPage(loginPage.getDriver());
    }

    @Given("Random user api")
    public void random_user_api() throws FileNotFoundException {
        String basePath = System.getProperty("user.dir") + "/src/test/resources/data/";
        HashMap<String, String> hm = (HashMap<String, String>) YamlReader.getData(basePath + "data.yaml", "randomusercreater").get("testdata");
        System.out.println(hm.get("url"));
        createUserApiManager = new CreateUserApiManager(hm.get("url"));
    }

    @When("This api is hit")
    public void this_api_is_hit() throws JsonProcessingException {
        createUserApiManager.execute();

    }

    @Then("A random user is generated")
    public void a_random_user_is_generated() throws JsonProcessingException {
        createUserApiManager.setApiData();
    }

    @Given("url for registration")
    public void url_for_registration() {
       Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }


    @When("user searches a product")
    public void user_searches_a_product() {
        homePage.searchClothes("");
    }

    @When("Adds the product to cart")
    public void adds_the_product_to_cart() {
        productListingPage.clickAddToCart();
    }

    @Then("user should be able to see the product in cart")
    public void user_should_be_able_to_see_the_product_in_cart() {
        productDetailsPage.addToCart();
    }

    @When("user clicks on place order")
    public void user_clicks_on_place_order() {
        commonElements.waitForLoaderToDisapper();
        paymentPage.clickPlaceOrder();
    }

    @Then("user should be able to register")
    public void user_should_be_able_to_register() {
        registrationPage.isRegistrationPageDisplayed();
    }

    @Given("user clicks on register button")
    public void user_clicks_on_register_button() {
        loginPage.clickCreateAccount();
    }
    @Given("user fills all registration details")
    public void user_fills_all_registration_details() {
        String firstName = createUserApiManager.getRoot().getResults().get(0).getName().getFirst();
        String lastName = createUserApiManager.getRoot().getResults().get(0).getName().getLast();
        String email = createUserApiManager.getRoot().getResults().get(0).getEmail();
        registrationPage.enterRegistrationDetails(firstName, lastName, email, "Unlimint@123");
    }
    @When("user fills firstname as {string} and lastname as {string} and email as {string} in registration details")
    public void user_fills_firstname_as_eva_and_lastname_as_shelton_and_email_as_eva_shelton_example_com_in_registration_details(String firstname,String lastname,String email) {
        if(firstname.equals("firstname")) {
            firstname = createUserApiManager.getRoot().getResults().get(0).getName().getFirst();
            lastname = createUserApiManager.getRoot().getResults().get(0).getName().getLast();
            email = createUserApiManager.getRoot().getResults().get(0).getEmail();
        }
        registrationPage.enterRegistrationDetails(firstname, lastname, email, "Unlimint@123");
    }


    @When("searching the product")
    public void searching_the_product() {
        homePage.searchClothes("");
    }
    @When("add the product to cart")
    public void add_the_product_to_cart() {
        productListingPage.clickAddToCart();
        productDetailsPage.addToCart();
    }
    @When("filling all the address details")
    public void filling_all_the_address_details() {
        String street = String.valueOf(createUserApiManager.getRoot().getResults().get(0).getLocation().getStreet().getNumber());
        street = street + createUserApiManager.getRoot().getResults().get(0).getLocation().getStreet().getName();
        String pinCode = createUserApiManager.getRoot().getResults().get(0).getLocation().getPostcode();
        String country = createUserApiManager.getRoot().getResults().get(0).getLocation().getCountry();
        String phone = createUserApiManager.getRoot().getResults().get(0).getPhone();
        String state = createUserApiManager.getRoot().getResults().get(0).getLocation().getState();
        String city = createUserApiManager.getRoot().getResults().get(0).getLocation().getCity();
        checkOutPage.fillAddressDetails(street, pinCode, state, country, phone, city);
    }
    @Then("user should be able to place the order")
    public void user_should_be_able_to_place_the_order() {
        commonElements.waitForLoaderToDisapper();
        paymentPage.clickPlaceOrder();
    }

    @Then("success screen should be displayed")
    public void success_screen_should_be_displayed() {
        Assert.assertEquals(successPage.validateSuccessMessage(), "Thank you for your purchase!");
    }
    @Then("user already exists message is shown")
    public void user_already_exists_message_is_shown() {
        Assert.assertTrue(registrationPage.isUserExist());
    }

@After
public void tearDown(){
    loginPage.getDriver().quit();
    }
}
