package api;


import api.authorization.*;
import api.registration.MethodsForGamerRegistration;
import api.registration.SuccessfulRegistrationGamer;
import api.user_data.MethodsForGetUserData;
import api.user_data.SuccessfulGetUserData;
import org.junit.Assert;
import org.junit.Test;



public class ApiTestTask {
    
    @Test
    public void getGuestSToken()  {
        MethodsForAuthorization methodsForAuthorization = new MethodsForAuthorization();
        SuccessfulGetAGuestToken successGetToken = methodsForAuthorization.gettingAGuestToken(); 
        Assert.assertTrue(successGetToken.getAccess_token().trim().length() != 0);
    }
    @Test
    public void registrationOfANewGamer()  {
        //arrange
        MethodsForAuthorization methodsForAuthorization = new MethodsForAuthorization();
        SuccessfulGetAGuestToken successGetToken = methodsForAuthorization.gettingAGuestToken();
        //aсt
        MethodsForGamerRegistration methodsForGamerRegistration = new MethodsForGamerRegistration();
        // Метод регистрации нового игрока принимает токен гостя, а возращает объект с телом ответа сервера 
        SuccessfulRegistrationGamer successfulRegistrationGamer = methodsForGamerRegistration.registrationANewGamer(successGetToken.getAccess_token()); 
        // Метод сравнения принимает объект с телом ответа сервера после регистарции игрока, и сравнивает с ожидаемыми параметрами ответа   
        methodsForGamerRegistration.checkingTheReceivedResponse(successfulRegistrationGamer);
    }
    @Test
    public void logInUnderTheCreatedGamer()  {
        //arrange
        MethodsForAuthorization methodsForAuthorization = new MethodsForAuthorization();
        SuccessfulGetAGuestToken successGetToken = methodsForAuthorization.gettingAGuestToken();
        MethodsForGamerRegistration methodsForGamerRegistration = new MethodsForGamerRegistration();
        SuccessfulRegistrationGamer successfulRegistrationGamer = methodsForGamerRegistration.registrationANewGamer(successGetToken.getAccess_token());
        //act
        // Метод авторизации принимает логин и пароль, а возращает обект с телом ответа сервера
        SuccessfulGetATokenAfterAuthorization successfulGetATokenAfterAuthorization = methodsForAuthorization.gettingAGuestTokenAfterAuthorization(
                methodsForGamerRegistration.getUserName(), methodsForGamerRegistration.getUserPassword());
        Assert.assertTrue(successfulGetATokenAfterAuthorization.getAccess_token().trim().length() != 0);
    }
    @Test
    public void requestingDataYourGamer()  {
        //arrange
        MethodsForAuthorization methodsForAuthorization = new MethodsForAuthorization();
        SuccessfulGetAGuestToken successGetToken = methodsForAuthorization.gettingAGuestToken();
        MethodsForGamerRegistration methodsForGamerRegistration = new MethodsForGamerRegistration();
        SuccessfulRegistrationGamer successfulRegistrationGamer = methodsForGamerRegistration.registrationANewGamer(successGetToken.getAccess_token());
        SuccessfulGetATokenAfterAuthorization successfulGetATokenAfterAuthorization = methodsForAuthorization.gettingAGuestTokenAfterAuthorization(
                methodsForGamerRegistration.getUserName(), methodsForGamerRegistration.getUserPassword());
        //act
        MethodsForGetUserData methodsForGetUserData = new MethodsForGetUserData();
        // Метод запроса данных текущего игрока принимает токен и id, а возращает объект с телом ответа сервера 
        SuccessfulGetUserData successfulGetUserData = methodsForGetUserData.gettingYourUserData(
                successfulGetATokenAfterAuthorization.getAccess_token(), successfulRegistrationGamer.getId());
        // Метод сравнения принимает объект с телом ответа сервера после запроса данных текущего игрока (+ логин, емаил, имя, отчество)
        //,  и сравнивает с ожидаемыми параметрами ответа   
        methodsForGetUserData.checkingTheReceivedUserData(successfulGetUserData, successfulRegistrationGamer.getUsername()
                , successfulRegistrationGamer.getEmail(), successfulRegistrationGamer.getName(), successfulRegistrationGamer.getSurname());
    }
    @Test
    public void requestingDataOfAnotherGamer()  {
        //arrange
        MethodsForAuthorization methodsForAuthorization = new MethodsForAuthorization();
        SuccessfulGetAGuestToken successGetToken = methodsForAuthorization.gettingAGuestToken();
        MethodsForGamerRegistration methodsForGamerRegistration = new MethodsForGamerRegistration();
        SuccessfulRegistrationGamer successfulRegistrationGamer = methodsForGamerRegistration.registrationANewGamer(successGetToken.getAccess_token());
        SuccessfulGetATokenAfterAuthorization successfulGetATokenAfterAuthorization = methodsForAuthorization.gettingAGuestTokenAfterAuthorization(
                methodsForGamerRegistration.getUserName(), methodsForGamerRegistration.getUserPassword());
        //act
        MethodsForGetUserData methodsForGetUserData = new MethodsForGetUserData();
        // Метод запроса данных игрока принимает токен, а возращает объект с телом ответа сервера (ожидается 404 ошибка)
        SuccessfulGetUserData successfulGetUserData = methodsForGetUserData.gettingYourOtherPlayerSData(
                successfulGetATokenAfterAuthorization.getAccess_token());
    }
}
