package api.authorization;

public class SuccessfulGetATokenAfterAuthorization {
    private String token_type;
    private Integer expires_in;
    private String access_token;
    private String refresh_token;

    public SuccessfulGetATokenAfterAuthorization(String token_type, Integer expires_in, String access_token, String refresh_token) {
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }
}
