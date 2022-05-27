package api.registration;

import api.authorization.MethodsForAuthorization;
import api.base_actions.Accesses;
import api.base_actions.RandomData;
import api.spec.Specifications;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.Base64;
import java.util.Currency;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class MethodsForGamerRegistration  {
    RandomData randomData = new RandomData();
    private String userName = randomData.randomString(10);
    private String userPassword = Base64.getEncoder().encodeToString(randomData.randomString(10).getBytes());
    private String userEmail = randomData.randomString(10) + "@gmail.com";
    private String name = randomData.randomStringOfEnglishLetters(10);
    private String surName = randomData.randomStringOfEnglishLetters(10);

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public SuccessfulRegistrationGamer registrationANewGamer (String token){
        Accesses accesses = new Accesses();
        Specifications.installSpecification(Specifications.requestSpec(accesses.getUrl()), Specifications.responseSpecOk201());
        String currencyCode = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        GamerRegistration gamerRegistration = new GamerRegistration(userName, userPassword, userPassword, userEmail, name, surName, currencyCode);
        SuccessfulRegistrationGamer successfulRegistrationGamer = given()
                .headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .body(gamerRegistration)
                .when()
                .post( "v2/players")
                .then().log().all()
                .extract().as(SuccessfulRegistrationGamer.class);
        return successfulRegistrationGamer;
    }
    public void checkingTheReceivedResponse(SuccessfulRegistrationGamer successfulRegistrationGamer){
        Assert.assertNotNull(successfulRegistrationGamer.getId());
        Assert.assertNull(successfulRegistrationGamer.getCountry_id());
        Assert.assertNull(successfulRegistrationGamer.getTimezone_id());
        Assert.assertEquals(userName, successfulRegistrationGamer.getUsername());
        Assert.assertEquals(userEmail, successfulRegistrationGamer.getEmail());
        Assert.assertEquals(name, successfulRegistrationGamer.getName());
        Assert.assertEquals(surName, successfulRegistrationGamer.getSurname());
        Assert.assertNull(successfulRegistrationGamer.getGender());
        Assert.assertNull(successfulRegistrationGamer.getPhone_number());
        Assert.assertNull(successfulRegistrationGamer.getBirthdate());
        Assert.assertEquals(true, successfulRegistrationGamer.getBonuses_allowed());
        Assert.assertEquals(false, successfulRegistrationGamer.getIs_verified());
    }
}
