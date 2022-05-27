package api.user_data;

import api.base_actions.Accesses;
import api.registration.SuccessfulRegistrationGamer;
import api.spec.Specifications;

import api.authorization.MethodsForAuthorization;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class MethodsForGetUserData extends Accesses {

    public SuccessfulGetUserData gettingYourUserData(String token, Integer id) {
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOk200());
        SuccessfulGetUserData successfulGetUserData = given()
                .headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .get("v2/players/" + id)
                .then().log().all()
                .extract().as(SuccessfulGetUserData.class);
        return successfulGetUserData;
    }
    public SuccessfulGetUserData gettingYourOtherPlayerSData(String token) {
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecError404());
        SuccessfulGetUserData successfulGetUserData = given()
                .headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .get("v2/players/" )
                .then().log().all()
                .extract().as(SuccessfulGetUserData.class);
        return successfulGetUserData;
    }

    public void checkingTheReceivedUserData(SuccessfulGetUserData successfulGetUserData, String userName, String userEmail
            , String name, String surName) {
        Assert.assertNotNull(successfulGetUserData.getId());
        Assert.assertNull(successfulGetUserData.getCountry_id());
        Assert.assertNull(successfulGetUserData.getTimezone_id());
        Assert.assertEquals(userName, successfulGetUserData.getUsername());
        Assert.assertEquals(userEmail, successfulGetUserData.getEmail());
        Assert.assertEquals(name, successfulGetUserData.getName());
        Assert.assertEquals(surName, successfulGetUserData.getSurname());
        Assert.assertNull(successfulGetUserData.getGender());
        Assert.assertNull(successfulGetUserData.getPhone_number());
        Assert.assertNull(successfulGetUserData.getBirthdate());
        Assert.assertEquals(true, successfulGetUserData.getBonuses_allowed());
        Assert.assertEquals(false, successfulGetUserData.getIs_verified());
    }

}
