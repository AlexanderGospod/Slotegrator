package api.authorization;

public class GetTokenAfterAuthorization {
    private String grant_type;
    private String username;
    private String password;

    public GetTokenAfterAuthorization(String grant_type, String username, String password) {
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
    }
}
