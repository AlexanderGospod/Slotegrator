package api.authorization;

public class GetAGuestSToken {
    private String grant_type;
    private String scope;

    public GetAGuestSToken(String grant_type, String scope) {
        this.grant_type = grant_type;
        this.scope = scope;
    }



}
