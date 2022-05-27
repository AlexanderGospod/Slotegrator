package api.authorization;

import api.base_actions.Accesses;
import api.registration.MethodsForGamerRegistration;
import api.spec.Specifications;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class MethodsForAuthorization extends Accesses {
    public static String getUrl() {
        return url;
    }


    public SuccessfulGetAGuestToken gettingAGuestToken(){
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOk200());
        GetAGuestSToken getAGuestSToken = new GetAGuestSToken("client_credentials", "guest:default");
        SuccessfulGetAGuestToken successGetToken = given()
                .auth()
                .preemptive()
                .basic(userNameForBasicAuth,BasicPassword)
                .body(getAGuestSToken)
                .when()
                .post( "v2/oauth2/token")
                .then().log().all()
                .extract().as(SuccessfulGetAGuestToken.class);
        return successGetToken;
    }
    public SuccessfulGetATokenAfterAuthorization gettingAGuestTokenAfterAuthorization(String userName, String userPassword) {
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOk200());
        GetTokenAfterAuthorization getTokenAfterAuthorization = new GetTokenAfterAuthorization
                ("password", userName, userPassword);
        SuccessfulGetATokenAfterAuthorization successfulGetATokenAfterAuthorization = given()
                .auth()
                .preemptive()
                .basic(userNameForBasicAuth,BasicPassword)
                .body(getTokenAfterAuthorization)
                .when()
                .post( "v2/oauth2/token")
                .then().log().all()
                .extract().as(SuccessfulGetATokenAfterAuthorization.class);
        return successfulGetATokenAfterAuthorization;
    }






}
