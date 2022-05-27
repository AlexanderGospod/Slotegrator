package api.base_actions;

import java.security.SecureRandom;


public class RandomData {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_______________";
    private static SecureRandom rnd = new SecureRandom();
    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rndom = new SecureRandom();
    public String randomStringOfEnglishLetters(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ABC.charAt(rndom.nextInt(ABC.length())));
        return sb.toString();
    }

//    private String username;
//    private String password;
//    private String email;
//    private String name;
//    private String surname;
//
//    public String getUsername() {
//        username = randomString(10);
//        return username;
//    }
//
//    public String getPassword() {
//        password = randomString(10);
//        return password;
//    }
//
//    public String getEmail() {
//        email = randomString(10) + "gmail.com";
//        return email;
//    }
//
//    public String getName() {
//        name = randomStringOfEnglishLetters(10);
//        return name;
//    }
//
//    public String getSurname() {
//        surname = randomStringOfEnglishLetters(10);
//        return surname;
//    }
}
